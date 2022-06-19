package com.example.moneymani.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R
import com.example.moneymani.data.WordData
import com.example.moneymani.listeners.OnWordClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.card_layout.view.*

class MyAdapter() :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

//    private lateinit var mOnWordClickListener: OnWordClickListener
//
//    fun setOnWordClickListener(listener: OnWordClickListener) {
//        this.mOnWordClickListener = listener
//    }

    var titles = arrayOf("경제", "가계수지", "가계순저축률", "금융", "자본주의", "부동산", "은행", "금융감독원", "GDP", "실질 GDP", "GNI", "경기", "수출경기", "내수경기", "물가", "물가지수", "소비자 물가지수", "생산자 물기자수", "인플레이션", "하이퍼인플레이션", "디플레이션", "스태그플레이션",
        "금리", "제1 금융권", "제2 금융권", "제3 금융권", "자본", "기준금리", "여신", "수신", "국채", "국고채"

    )
    var details = arrayOf("인간의 생활에 필요한 재화나 서비스를 생산하거나 소비하거나 분배하는 활동",
        "가정에서 일정 기간의 수입(명목소득)과 지출을 비교해서 남았는지 모자랐는지를 표시한 것",
        "가계부문의 순저축액을 가계순처분가능소득과 정부로부터 받은 사회적 현물이전 금액, 연금기금의 가계순지분 증감조정액을 합계한 금액",
        "금전을 융통하는 일. 특히 이자를 붙여서 자금을 대차하는 일과 그 수급 관계를 이른다.",
        "생산 수단을 자본으로서 소유한 자본가가 이윤 획득을 위하여 생산 활동을 하도록 보장하는 사회 경제 체제.",
        "움직여 옮길 수 없는 재산. 토지나 건물, 수목 따위이다.",
        "예금을 받아 그 돈을 자금으로 하여 대출, 어음 거래, 증권의 인수 따위를 업무로 하는 금융 기관.",
        "1999년에, 은행 감독원ㆍ보험 감독원ㆍ증권 감독원ㆍ신용 관리 기금의 네 감독 기관을 통합하여 신설한 금융 감독 기관.",
        "대한민국 안에서 생산된 모든 물질적 부를 합친 것",
        "실제로 생산된 물질적 부를 모두 합친 것",
        "우리나라 국민이 실제로 향유하는 물질적 부",
        "경제의 활동기운을 줄인 말",
        "'수출과 관련된 경제의 활동 기운'을 줄인 말",
        "'국내수요와 관련된 경제의 활동 기운'을 줄인 말",
        "물건의 가격을 줄인 말",
        "물가가 과거에 비해 얼마나 뛰었나 조사한 것",
        "소비자들에게 중요한 물건의 가격을 조사한 것",
        "생산자에게 중요한 각종 물건(원자재)의 가격을 조사한 것",
        "물가상승을 영어로 인플레이션이라고 한다",
        "물가가 상상을 초월할 정도로 공중부양 하는 현상",
        "물가하락을 영어로 디플레이션이라 한다",
        "경제가 엉망진창인데 물가가 상승하는 현상",
        "이자가 원금에서 차지하는 비중",
        "은행을 가리키는 말",
        "은행을 제외한 제도권 금융기관을 가리키는 말",
        "대부업체를 가리키는 말",
        "돈을 낳는 돈",
        "한국은행과 일반은행이 돈을 거래할 때의 금리",
        "은행이 우리에게 대출해주는 것",
        "우리가 은행에 예금하는 것"





        )
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var itemtitle: TextView = itemView.findViewById(R.id.item_title)
//        var itemdetail: TextView = itemView.findViewById(R.id.item_detail)
//    }

    // 1. Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)

        return MyViewHolder(cardView)
    }

    // 2. Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.containerView.item_title.text = titles[position]
        holder.containerView.item_detail.text = details[position]
//        holder.itemView.setOnClickListener{
//            mOnWordClickListener.onWordClick(position)
//        }

    }

    class MyViewHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer

    // 3. Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return 30
    }

}