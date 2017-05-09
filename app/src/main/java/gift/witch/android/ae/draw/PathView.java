package gift.witch.android.ae.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 *
 * 请参考http://android.jobbole.com/83384/
 */
public class PathView extends View {


    private Paint mPaint;

    public PathView(Context context) {
        super(context);
        initPaint();
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(0xFFFF9955);

        /**
         * setStyle默认是FILL，这样path必须是一个围起来图形
         */
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Path path1 = new Path();
        path1.moveTo(90, 130);
        path1.lineTo(150, 180);
        path1.lineTo(210, 180);
        path1.close();
        canvas.drawPath(path1, mPaint);


        Path path2 = new Path();
        RectF rectF = new RectF();
        rectF.set(90,200,120,240);
        path2.addRect(rectF, Path.Direction.CW);
        path2.lineTo(150,249);
        path2.close();
        canvas.drawPath(path2, mPaint);

        Path path3 = new Path();
        path3.moveTo(150,260);
        /**
         *  二次贝塞尔，实现平滑曲线；previousX, previousY为操作点，cX, cY为终点
         *  mPath.quadTo(previousX, previousY, cX, cY);
         */
        path3.quadTo(280,300,180,300);
        path3.lineTo(180,300);

        canvas.drawPath(path3, mPaint);


        Path path = new Path();
        Path src = new Path();

        path.addRect(0,0,200,200, Path.Direction.CW);
        src.addCircle(0,0,100, Path.Direction.CW);

        path.addPath(src,0,200);

        canvas.drawPath(path,mPaint);

    }
}
