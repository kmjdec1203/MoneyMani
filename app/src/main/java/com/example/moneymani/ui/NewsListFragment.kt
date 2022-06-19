package com.example.moneymani.ui

import android.content.Intent
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R
import com.example.moneymani.adapter.NewsListAdapter
import com.example.moneymani.base.BaseFragment
import com.example.moneymani.data.NewsRepository
import com.example.moneymani.data.RemoteNewsData
import com.example.moneymani.databinding.FragmentNewsListBinding
import com.example.moneymani.di.InjectorUtil
import com.example.moneymani.listeners.OnNewsClickListener
import com.example.moneymani.viewmodels.NewsListViewModel
import com.example.moneymani.viewmodels.NewsListViewModelFactory
import kotlinx.android.synthetic.main.fragment_news_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.java.KoinJavaComponent.inject

@ExperimentalCoroutinesApi
class NewsListFragment : BaseFragment<FragmentNewsListBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_news_list

    //private val newsListViewModelFactory: NewsListViewModelFactory by inject()
    private val adapter by lazy { NewsListAdapter(requireContext(), listOf()) }
    private val remoteDataSource = RemoteNewsData()
    private val repository = NewsRepository(remoteDataSource)
    private val viewModel: NewsListViewModel by viewModels { NewsListViewModelFactory(repository) }

    override fun init() {

        // RecyclerView
        rv_news_list.layoutManager = LinearLayoutManager(context)
        rv_news_list.adapter = adapter

        // 뉴스 기사를 클릭하면 웹뷰를 통해 기사를 띄워준다.
        adapter.setOnNewsClickListener(OnNewsClickListener {
            val intent = Intent(activity, NewsViewActivity::class.java)
            intent.putExtra("url", adapter.items[it].url)
            startActivity(intent)
        })


        // 페이징 처리
        rv_news_list.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                val totalItemCount = (recyclerView.adapter as NewsListAdapter).itemCount
                val lastItemPosition = totalItemCount-1
                // 스크롤이 마지막 아이템에 도달하면 로그를 출력
                if (lastVisibleItemPosition == lastItemPosition) {
                    Log.d("mainactivity", "도착! lastVisibleItemPosition=$lastVisibleItemPosition itemTotalCount=$totalItemCount")
                } else {
                    Log.d("mainactivity", "lastVisibleItemPosition=$lastVisibleItemPosition itemTotalCount=$totalItemCount")
                }
            }
        })

        // 화면을 당겨서 새로고침 처리
        layout_refresh.setOnRefreshListener {
            Log.d("MyRefresh", "새로고침 당김")
            viewModel.updateNewsData()
        }
    }
    // 뒤로가기를 두 번 누르면 종료처리
    private var tempTime: Long = 0
    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        if (currentTime-tempTime < 1000) {
            activity?.finish()
        }
        tempTime = currentTime
        makeToast("한 번 더 누르면 종료됩니다.")
    }

    override fun observe() {

        val newsList = mutableListOf<String>()

        // 뉴스 세팅
        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        viewModel.progress.observe(viewLifecycleOwner, Observer {
            layout_refresh.isRefreshing = it
        })
    }
}
