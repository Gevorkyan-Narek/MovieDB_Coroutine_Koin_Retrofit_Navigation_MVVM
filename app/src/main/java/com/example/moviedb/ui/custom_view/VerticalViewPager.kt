//package com.example.moviedb.ui.custom_view
//
//import android.content.Context
//import android.util.AttributeSet
//import android.view.MotionEvent
//import android.view.View
//import androidx.viewpager2.widget.ViewPager2
//import com.example.moviedb.R
//
//
//class VerticalViewPager : ViewPager2 {
//
//    private lateinit var swipeOrientation: SwipeOrientation
//
//    constructor(context: Context) : super(context) {
//        swipeOrientation = SwipeOrientation.HORIZONTAL
//    }
//
//    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
//        setSwipeOrientation(context, attributes)
//    }
//
//    private fun swapXY(event: MotionEvent): MotionEvent = event.apply {
//        setLocation(
//            event.y / height * width,
//            event.x / width * height
//        )
//    }
//
//    private fun setSwipeOrientation(context: Context, attrs: AttributeSet) {
//        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.VerticalViewPager)
//        swipeOrientation = SwipeOrientation.getOrientation(
//            typedArray.getInteger(
//                R.styleable.VerticalViewPager_swipe_orientation,
//                0
//            )
//        )
//        typedArray.recycle()
//        initSwipeMethods()
//    }
//
//    private fun initSwipeMethods() {
//        if (swipeOrientation === SwipeOrientation.VERTICAL) {
//            // The majority of the work is done over here
////            setPageTransformer(VerticalPageTransformer())
//            // The easiest way to get rid of the overscroll drawing that happens on the left and right
//            overScrollMode = OVER_SCROLL_NEVER
//        }
//    }
//
//    override fun onTouchEvent(ev: MotionEvent): Boolean = super.onTouchEvent(
//        if (swipeOrientation == SwipeOrientation.VERTICAL)
//            swapXY(ev)
//        else
//            ev
//    )
//
//    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
//        if (swipeOrientation == SwipeOrientation.VERTICAL) {
//            return super.onInterceptHoverEvent(swapXY(ev)).also { swapXY(ev) }
//        }
//        return super.onInterceptTouchEvent(ev)
//    }
//
//    private class VerticalPageTransformer : PageTransformer {
//
//        override fun transformPage(page: View, position: Float) {
//            if (position < -1 || position > 1) {
//                page.alpha = 0f
//            } else {
//                page.alpha = 1f
//                page.translationX = page.width * -position
//                page.translationY = page.height * position
//            }
//        }
//    }
//}
//
//enum class SwipeOrientation {
//    HORIZONTAL,
//    VERTICAL;
//
//    companion object {
//        fun getOrientation(value: Int) = when (value) {
//            0 -> HORIZONTAL
//            1 -> VERTICAL
//            else -> throw IllegalStateException("No valid value")
//        }
//    }
//}