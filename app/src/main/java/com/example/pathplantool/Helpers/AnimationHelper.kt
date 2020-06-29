package com.example.pathplantool.Helpers

import android.animation.ValueAnimator
import android.widget.ImageView
import java.sql.DriverManager.println
import kotlin.properties.Delegates

data class UpdatePos(var someImage: ImageView,var  sp_x: Float,var sp_y: Float, var sp_theta: Float, var _pos_x: Float, var _pos_y: Float, var _theta: Float) {

    var pos_x: Float by Delegates.observable(_pos_x) { prop, old, new ->
        println("Coordinate X changed from $old to $new")
        animateARobot(someImage, sp_x, sp_y, sp_theta, new, pos_y , pos_theta)
        _pos_x = new
    }

    var pos_y: Float by Delegates.observable(_pos_y) { prop, old, new ->
        println("Coordinate Y changed from $old to $new")
        animateARobot(someImage, sp_x, sp_y, sp_theta, pos_x, new, pos_theta )
        _pos_y = new
    }

    var pos_theta: Float by Delegates.observable(_theta) { prop, old, new ->
        println("Coordinate Theta changed from $old to $new")
        animateARobot(someImage, sp_x, sp_y, sp_theta, pos_x, pos_y, new )
        _theta = new
    }

}

fun animateARobot(Robot: ImageView, sp_x: Float, sp_y: Float, theta_0: Float, park_x: Float, park_y: Float, theta_1: Float)
{

    val robotView = Robot


    val animator_x = ValueAnimator.ofFloat(sp_x,park_x)
    val animator_y = ValueAnimator.ofFloat(sp_y,park_y)
    val animator_rotate = ValueAnimator.ofFloat(theta_0,theta_1)

    animator_x.start()
    animator_y.start()
    animator_rotate.start()


    //animator_x.duration = 10000

    animator_x.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
        override fun onAnimationUpdate(animation: ValueAnimator)
        {
            val animatedValue = animation.animatedValue as Float
            robotView.x = animatedValue
        }
    })

    //animator_y.duration = 10000

    animator_y.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
        override fun onAnimationUpdate(animation: ValueAnimator)
        {
            val animatedValue = animation.animatedValue as Float
            robotView.y = animatedValue
        }
    })
    animator_rotate.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
        override fun onAnimationUpdate(animation: ValueAnimator)
        {
            val animatedValue = animation.animatedValue as Float
            robotView.rotation = animatedValue
        }
    })

}


