package rakib.hasan.dynamicviews.utils

import rakib.hasan.dynamicviews.model.EsgQuestion

object Const {

    val SINGLE_VIEW_TYPE = 1
    val MULTIPLE_VIEW_TYPE = 2

    val SINGLE_VIEW_TYPE_ = "single"
    val MULTIPLE_VIEW_TYPE_ = "multiple"


    fun getList() : MutableList<EsgQuestion>{
        val items = mutableListOf<EsgQuestion>()
        items.add(EsgQuestion("Does the enterprise report on initiatives to recycle, reduce, reuse, substitute, treat or phase out total waste?", "single"))
        items.add(EsgQuestion("Does the enterprise report on initiatives to recycle, reduce, reuse, substitute, treat or phase out e-waste?", "single"))
        items.add(EsgQuestion("Is the enterprise aware that climate change can represent commercial risks and/or opportunities?", "single"))
        items.add(EsgQuestion("Does the enterprise have an environmental product innovation policy (eco-design, life cycle assessment, dematerialization)?", "single"))
        items.add(EsgQuestion("Does the enterprise claim to evaluate projects on the basis of environmental or biodiversity risks as well?", "single"))
        items.add(EsgQuestion("Is the enterprise linked to any controversy in the local community/Bazar because of labor wages, or suppliers' working conditions? (Delayed or not paying wages properly, Child labor, unsafe working environment)", "multiple"))
        items.add(EsgQuestion("Which of the following has the enterprise implemented in its system? (Select all the options that apply.)", "multiple"))
        items.add(EsgQuestion("Does the enterprise describe the implementation of its product responsibility policy or procedures?", "multiple"))
        items.add(EsgQuestion("Which of the following barriers does the enterprise face when hiring employees?", "multiple"))
        items.add(EsgQuestion("Does the enterprise strive to improve customer satisfaction or to be a fair competitor?", "multiple"))
        return items
    }
}