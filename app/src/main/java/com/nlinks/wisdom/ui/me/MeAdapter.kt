package com.nlinks.wisdom.ui.me

import androidx.appcompat.widget.AppCompatImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.nlinks.wisdom.R
import com.nlinks.wisdom.model.bean.me.MeMenuInfo

/**
 * @author chenqinlan
 * createTime 2019/7/12 0012
 * description
 */
class MeAdapter(layoutResId: Int = R.layout.item_me) : BaseQuickAdapter<MeMenuInfo, BaseViewHolder>(layoutResId) {
    override fun convert(helper: BaseViewHolder?, item: MeMenuInfo?) {
        helper!!.setText(R.id.tv_me_content, item!!.content)
        var ivIcon = helper.getView<AppCompatImageView>(R.id.iv_me_icon)
        ivIcon.run{
            setImageResource(R.drawable.icon_company)
        }
    }

}