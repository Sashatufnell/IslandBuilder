package com.example.islandbuilder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyDragShadowBuilder extends View.DragShadowBuilder {

    // The drag shadow image, defined as a drawable object.
    private static Drawable shadow;

    // Constructor.
    public MyDragShadowBuilder(View view) {

        // Store the View parameter.
        super(view);

        // Create a draggable image that fills the Canvas provided by the
        // system.
        shadow = new ColorDrawable(Color.LTGRAY);
    }

    // Define a callback that sends the drag shadow dimensions and touch point
// back to the system.
    @Override
    public void onProvideShadowMetrics (Point size, Point touch) {

        // Define local variables.
        int width, height;


        width = getView().getWidth() / 2;


        height = getView().getHeight() / 2;


        shadow.setBounds(0, 0, width, height);


        size.set(width, height);


        touch.set(width / 2, height / 2);
    }

    @Override
    public void onDrawShadow(Canvas canvas) {


        shadow.draw(canvas);
    }
}