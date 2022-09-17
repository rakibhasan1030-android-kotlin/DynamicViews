package rakib.hasan.dynamicviews.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import rakib.hasan.dynamicviews.R
import rakib.hasan.dynamicviews.databinding.MultipleItemsViewBinding
import rakib.hasan.dynamicviews.databinding.SingleItemsViewBinding
import rakib.hasan.dynamicviews.model.EsgQuestion
import rakib.hasan.dynamicviews.utils.Const.MULTIPLE_VIEW_TYPE
import rakib.hasan.dynamicviews.utils.Const.SINGLE_VIEW_TYPE
import rakib.hasan.dynamicviews.utils.Const.SINGLE_VIEW_TYPE_

class MainRvAdapter(
    private val context: Context,
    private val list: MutableList<EsgQuestion>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            SINGLE_VIEW_TYPE -> SingleViewTypeViewHolder(
                context,
                SingleItemsViewBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> MultipleViewTypeViewHolder(
                context,
                MultipleItemsViewBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].optionType) {
            SINGLE_VIEW_TYPE_ -> {
                (holder as SingleViewTypeViewHolder).bind(list[position])
            }
            else -> {
                (holder as MultipleViewTypeViewHolder).bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int =
        when (list[position].optionType) {
            SINGLE_VIEW_TYPE_ -> SINGLE_VIEW_TYPE
            else -> MULTIPLE_VIEW_TYPE
        }

    private inner class SingleViewTypeViewHolder(
        context: Context,
        private val binding: SingleItemsViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceType")
        fun bind(question: EsgQuestion) {

            binding.questionTv.text = question.question
            val radioGroup = binding.optionsRg
            radioGroup.removeAllViews()
            for (i in 1..5) {
                val radioButton = RadioButton(context)
                radioButton.layoutParams = ConstraintLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                radioButton.text = question.optionType
                radioButton.id = i
                radioGroup.addView(radioButton)
            }
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                var text = group.checkedRadioButtonId
                Toast.makeText(context, text.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }

    private inner class MultipleViewTypeViewHolder(
        context: Context,
        private val binding: MultipleItemsViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(question: EsgQuestion) {

        }

    }
}

