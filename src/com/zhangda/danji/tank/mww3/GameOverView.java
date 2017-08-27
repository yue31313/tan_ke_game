package com.zhangda.danji.tank.mww3;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class GameOverView extends View{
	private MainActivity mainActivity;//得到activity的引用  用来发handle消息
	private Bitmap gameover;//背景  
	public GameOverView(Context context) {
		super(context);
		this.mainActivity = (MainActivity) context;
		gameover = BitmapFactory.decodeResource(this.getResources(), R.drawable.gameover);
		this.setFocusable(true);//设置当前View先拥有控制焦点
	}
	protected void onDraw(Canvas canvas) {
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		RectF rectF = new RectF(0, 0, width, height);   //w和h分别是屏幕的宽和高，也就是你想让图片显示的宽和高  
		canvas.drawBitmap(gameover, null, rectF, null);
//		canvas.drawBitmap(gameover, 0, 0, null);// 
	}
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mainActivity.myHandler.sendEmptyMessage(4);//给activity发送消息 让activity切换页面
			break;
		default:
			break;
		}
		postInvalidate();
		return true;//触摸时间不传递给activity
	}

}
