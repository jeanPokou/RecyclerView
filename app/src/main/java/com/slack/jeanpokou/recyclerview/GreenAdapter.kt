package com.slack.jeanpokou.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import org.jetbrains.anko.find


class GreenAdapter ( private val numberItems:Int,private var mOnClickListener : ListItemClickListener) : RecyclerView.Adapter<GreenAdapter.NumberViewHolder>() {
    /**
     * Called by RecyclerView to display the data at the specified position. This method
     * should update the contents of the [ViewHolder.itemView] to reflect the item at
     * the given position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this
     * method again if the position of the item changes in the data set unless the item itself
     * is invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside this
     * method and should not keep a copy of it. If you need the position of an item later on
     * (e.g. in a click listener), use [ViewHolder.getPosition] which will have the
     * updated position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: NumberViewHolder?, position: Int) {
        holder?.bind(position)
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return numberItems
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display different
     * items in the data set, it is a good idea to cache references to sub views of the View to
     * avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.number_list_item,parent,false)
        return  NumberViewHolder(view)
    }

    interface ListItemClickListener {
        fun onListItemClick (clickedItemIndex : Int)

    }
    inner class NumberViewHolder (itemView : View) :RecyclerView.ViewHolder (itemView) {

       private val listItemNumberView = itemView.find<TextView>(R.id.tv_item_number)
        fun bind(listIndex : Int) {
            with(listItemNumberView) {
                text = listIndex.toString()
                setOnClickListener {
                   mOnClickListener.onListItemClick(listIndex)
                }
            }
        }

    }


}




