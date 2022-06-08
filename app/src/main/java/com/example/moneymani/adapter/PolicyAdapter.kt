package com.example.moneymani.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R

class PolicyAdapter :
    RecyclerView.Adapter<PolicyAdapter.PolicyViewHolder>() {

        var titles = arrayOf("경제", "금융", "자본주의", "부동산", "은행", "금융감독원", "아아", "권민정", "프실", "고도현")
        var details = arrayOf("인간의 생활에 필요한 재화나 서비스를 생산하거나 소비하거나 분배하는 활동",
            "금전을 융통하는 일. 특히 이자를 붙여서 자금을 대차하는 일과 그 수급 관계를 이른다.",
            "생산 수단을 자본으로서 소유한 자본가가 이윤 획득을 위하여 생산 활동을 하도록 보장하는 사회 경제 체제.",
            "움직여 옮길 수 없는 재산. 토지나 건물, 수목 따위이다.",
            "예금을 받아 그 돈을 자금으로 하여 대출, 어음 거래, 증권의 인수 따위를 업무로 하는 금융 기관.",
            "1999년에, 은행 감독원ㆍ보험 감독원ㆍ증권 감독원ㆍ신용 관리 기금의 네 감독 기관을 통합하여 신설한 금융 감독 기관.",
            "하하", "천재", "싫다", "탁구 뜨자")

        class PolicyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var itemtitle: TextView = itemView.findViewById(R.id.item_policy_title)
            var itemdetail: TextView = itemView.findViewById(R.id.item_policy_detail)
        }

        // 1. Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): PolicyViewHolder {
            // create a new view
            val cardView = LayoutInflater.from(parent.context)
                .inflate(R.layout.policy_card_layout, parent, false)

            return PolicyViewHolder(cardView)
        }

        // 2. Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: PolicyViewHolder, position: Int) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.itemtitle.text = titles[position]
            holder.itemdetail.text = details[position]

        }

        // 3. Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount(): Int {
            return 10
        }
}