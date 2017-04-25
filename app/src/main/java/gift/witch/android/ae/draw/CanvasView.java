package gift.witch.android.ae.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {


    private MyPaint myPaint = new MyPaint();

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        myPaint.setStrokeWidth(5);
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setTextSize(36);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        myPaint.setColor(0xFFe3796a);
        canvas.save();
        canvas.translate(100,0);

        canvas.drawText("哇哈哈 wahahaha",0,36,myPaint);
        canvas.drawRect(0,0,100,40,myPaint);

        canvas.drawPoint(120,80,myPaint);

        /**
         * 使用rect
         */
        RectF rectF = new RectF();
        rectF.set(0,120,130,180);
        canvas.drawRoundRect(rectF,12,24,myPaint);

        /**
         * 使用path
         */
        Path path = new Path();
        path.moveTo(0,220);
        path.lineTo(100,550);
        canvas.drawPath(path,myPaint);

        /**
         * 使用store和restore
         */
        canvas.restore();
        canvas.drawPath(path,myPaint);

        /**
         * 使用saveLayer
         */
        int count = canvas.saveLayerAlpha(0, 0, 200, 200, 0x1A, Canvas.ALL_SAVE_FLAG);
        myPaint.setColor(Color.BLUE);
        canvas.drawCircle(125, 125, 75, myPaint);
        canvas.restoreToCount(count);

    }
}
