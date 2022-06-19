package com.example.moneymani.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymani.R

class PolicyAdapter :
    RecyclerView.Adapter<PolicyAdapter.PolicyViewHolder>() {

        var titles = arrayOf("청년희망키움통장", "빈곤 청년에 대한 근로인센티브 확대", "주거안정 월세대출", "실업급여", "햇살론 유스", "군 복무이자면제", "알뜰교통카드", "청년형 ISA 운영", "청년 디지털 일자리 사업", "해외취업정착지원금", "참 괜찮은 중소기업 플랫폼", "청년여성 멘토링")
        var details = arrayOf("저축액 적립/지원. 3년 만기일시지급식\n- 월 저축액: 근로, 사업소득공제액 10만원+근로소득 장려금",
            "(근로소득공제 확대)\n" +
                    "- 교재비·주거비 인상 등 물가상승률을 고려하여 기초생활수급가구 청년의 근로소득 공제율이 상향 조정됨\n",
            "1. 호당대출한도\n" +
                    "최대 960만원 (매월 최대 40만원 이내), 주거급여 수급자의 경우 대출한도에서 주거급여 수급액 금액만큼 제외",
            "*1일 구직급여 수급액은 퇴직 전 3개월간의 1일 평균임금의 60% (단, 근로시간은 소정근로시간 8시간으로 계산).",
            "저소득 청년층 대상 저리 대출 대학생, 미취업청년 4.0%, 사회초년생 4.5%, 사회적 배려대상* 청년층 3.6%",
            "(1)취업후 상환 학자금 대출\n" +
                    "- 면제 금액: 군 복무기간 동안 발생하는 정상약정이자",
            "- 대중교통을 이용하기 위해 걷거나 자전거로 이동한 거리만큼 마일리지를 적립하여 지급",
            "ISA 계좌에 다양한 금융상품을 담아 운용하고, 금융상품별 손익을 통산하여 순이익에 세제혜택 부여",
            "지급받은 임금수준에 비례하여 인건비 지급(최대 180만원)하고 간접노무비(10만원)를 추가 지원",
            "신흥국 분류국가\n" +
                    "(지원금 우대국가) 600만원",
            "1. 사용자의 실시간 위치 및 맞춤형 조건에 기반한 우수기업 정보제공\n" +
                    "- 지도 서비스를 활용해 내 주변 우수 중소기업의 확인 및 구직자 맞춤검색 가능",
            "그룹멘토링 및 멘토링의 날 운영(멘토별 공개강좌 운영, 권역별 실무 멘토링 진행)")

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
            return 12
        }
}