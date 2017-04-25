package gift.witch.android.ae.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PrimaryView extends View{


    private Path mPath;
    private Path mPath2;

    private MyPaint myPaint = new MyPaint();
    private MyPaint myPaint2 = new MyPaint();
    public PrimaryView(Context context) {
        super(context);
        initPaint();
        initPath();
    }

    public PrimaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initPath();
    }

    public PrimaryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initPath();
    }

    private void initPaint(){
        myPaint.setColor(0xFFE07362);
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(10.0f);
        myPaint.setAntiAlias(false);
        myPaint.setTextSize(50);
        myPaint2.set(myPaint);
    }

    private void initPath() {
        // 实例化路径
        mPath = new Path();
        mPath2 = new Path();
        // 定义路径的起点
        mPath.moveTo(10, 550);
        mPath2.moveTo(10, 550+100);
        // 定义路径的各个点
        for (int i = 0; i <= 30; i++) {
            float i1 = 550 + (float) (Math.random() * 100);
            mPath.lineTo(i * 35, i1);
            mPath2.lineTo(i * 35,i1+100);
        }
    }



    protected void onDraw(Canvas canvas) {
        //disableHardwareRendering(this);
        canvas.drawCircle(50,50,100,myPaint);
        canvas.drawPath(mPath, myPaint);
        canvas.drawText("wo 你好",30.0f,380.0f,myPaint);

        /**
         * setFakeBoldText
         */
        //myPaint.setFakeBoldText(true);
        /**
         * setShader
         */
        /*
        LinearGradient mLinearGradient = new LinearGradient(0, 0, 100, 100, new int[] {
                Color.RED, Color.YELLOW, Color.BLACK, Color.WHITE },
                new float[] { 0, .1F, .8F, .9F }, Shader.TileMode.REPEAT);

        myPaint.setShader(mLinearGradient);

        */

        /***
         *  setColorFilter
         */
        /*
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
                0, 0, 0, 0, 0,  // 红色向量
                0, 1, 0, 0, 0,  // 绿色向量
                0, 0, 1, 0, 0,  // 蓝色向量
                0, 0, 0, 1, 0,  // 透明度向量
        });
        myPaint.setColorFilter(colorFilter);
        */



        //myPaint.setStrokeWidth(10);
        /**
         *
         */

        /*
        myPaint.setStrokeMiter(100);
        myPaint.setStrokeCap(Paint.Cap.SQUARE);
        myPaint.setStrokeJoin(Paint.Join.ROUND);
         */
        /**
         * setStyle
         */
        //myPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        /**
         * setPathEffect
         */
        //myPaint.setPathEffect(new CornerPathEffect(50));

        /**
         *setMaskFilter
         */
        /*
        // 设置光源的方向
        float[] direction = new float[]{ 1, 1, 1 };
        //设置环境光亮度
        float light = 0.4f;
        // 选择要应用的反射等级
        float specular = 6;
        // 向mask应用一定级别的模糊
        float blur = 3.5f;

        EmbossMaskFilter emboss=new EmbossMaskFilter(direction,light,specular,blur);
        myPaint.setMaskFilter(emboss);
        */

        /**
         * setShadowLayer
         */
        //myPaint2.setShadowLayer(20,-20,30, Color.BLACK);

        /**
         * setLetterSpacing
         */
        //myPaint2.setLetterSpacing(10f);
        /**
         * setTextAlign
         */
        //myPaint2.setTextAlign(Paint.Align.RIGHT);
        /**
         * setTextScaleX
         */
        //myPaint2.setTextScaleX(2);
        /**
         * setTextSkewX
         */
        //myPaint2.setTextSkewX(.0f);

        canvas.drawPath(mPath2, myPaint2);
        canvas.drawText("wo 你好",30.0f,500.0f,myPaint2);
        canvas.drawCircle(160,50,100,myPaint2);
    }


    public static void disableHardwareRendering(View v) {
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            v.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

}
