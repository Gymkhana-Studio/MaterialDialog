package android.app.MaterialDialogs;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.v7.app.AlertDialog;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.util.DisplayMetrics;
import android.graphics.*;
import android.view.*;

public class MaterialDialog {
	private Context context;
	private Activity activity;
	private int backgroundColors, headerColors, titleColors, textColors, btnColors;
	private MaterialDialogListener pListener;
	private Animation animation;
	private boolean cancel;
	public MaterialDialog(Builder build){
		this.context = build.context;
		this.activity = build.activity;
		this.backgroundColors = build.backgroundColors;
		this.headerColors = build.headerColors;
		this.animation = build.animation;
		this.pListener = build.pListener;
		this.titleColors = build.titleColors;
		this.textColors = build.textColors;
		this.btnColors = build.btnColors;
		this.cancel = build.canceled;
	}
	public static class Builder{
		private Context context;
		private Activity activity;
		private int backgroundColors = 0xFFFFFFFF;
		private int headerColors = 0xFF3F51B5;
		private int titleColors = 0xFFFFFFFF;
		private int textColors = 0xFF000000;
		private int btnColors = 0xFF3F51B5;
		private Animation animation;
		private MaterialDialogListener pListener;
		private String msg, btn, title;
		private int resIcon;
		private boolean canceled = true;
		public Builder(Context context){
			this.context = context;
			this.activity = (Activity)this.context;
		}
		public Builder setCancel(boolean s){
			this.canceled = s;
			return this;
		}
		public Builder setAnimation(Animation animation){
            this.animation=animation;
            return this;
        }
		public Builder setTextColor(int s){
			this.textColors = s;
			return this;
		}
		public Builder setButtonColors(int s){
			this.btnColors = s;
			return this;
		}
		public Builder setBackgroundColor(int s){
			this.backgroundColors = s;
			return this;
		}
		public Builder setHeaderColors(int s){
			this.headerColors = s;
			return this;
		}
		public Builder setTitleColor(int s){
			this.titleColors = s;
			return this;
		}
		public Builder setTitle(String s){
			this.title = s;
			return this;
		}
		public Builder setMessage(String s){
			this.msg = s;
			return this;
		}
		public Builder setTextButton(String s){
			this.btn = s;
			return this;
		}
		public Builder setIcon(int icon){
			this.resIcon = icon;
			return this;
		}
		public Builder setOnClicked(MaterialDialogListener pListener){
			this.pListener=pListener;
			return this;
		}
		public MaterialDialog show(){
			AlertDialog.Builder dialogBuilder;
			final AlertDialog alertDialog;
			LinearLayout Head, RootLayout;
			GradientDrawable top, root;
			View layoutView;
			TextView msgContent, textButton, textTitle;
			ImageView icon;
			dialogBuilder = new AlertDialog.Builder(this.context, R.style.fix);
			layoutView = this.activity.getLayoutInflater().inflate(R.layout.material_dialog, null);
			dialogBuilder.setView(layoutView);
			alertDialog = dialogBuilder.create();
			
			if(animation==Animation.POP) {
				alertDialog.getWindow().getAttributes().windowAnimations = R.style.PopTheme;
			} else if(animation==Animation.SIDE) {
				alertDialog.getWindow().getAttributes().windowAnimations = R.style.SideTheme;
			} else if(animation==Animation.SLIDE) {
				alertDialog.getWindow().getAttributes().windowAnimations = R.style.SlideTheme;
			} else if (animation==Animation.UP) {
				alertDialog.getWindow().getAttributes().windowAnimations = R.style.UpTheme;
			} else if (animation==Animation.FADE){
				alertDialog.getWindow().getAttributes().windowAnimations = R.style.FadeTheme;
			} else {}
			alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			Head = layoutView.findViewById(R.id.Head);
			RootLayout = layoutView.findViewById(R.id.Root);
			textButton = layoutView.findViewById(R.id.textButton);
			msgContent = layoutView.findViewById(R.id.msgDialog);
			textTitle = layoutView.findViewById(R.id.titleDialog);
			icon = layoutView.findViewById(R.id.iconDialog);
			
			textTitle.setTextColor(this.titleColors);
			textTitle.setText(this.title);
			msgContent.setTextColor(this.textColors);
			msgContent.setText(this.msg);
			textButton.setTextColor(this.btnColors);
			textButton.setText(this.btn);
			if (resIcon!=0){
				icon.setVisibility(View.VISIBLE);
				icon.setImageResource(this.resIcon);
			} else {
				icon.setVisibility(View.GONE);
			}
			top = new GradientDrawable();
			top.setColor(this.headerColors);
			top.setCornerRadii(new float[] {20, 20, 20, 20, 0, 0, 0, 0});
			Head.setBackground(top);
			root = new GradientDrawable();
			root.setColor(this.backgroundColors);
			root.setCornerRadii(new float[] {20, 20, 20, 20, 20, 20, 20, 20});
			RootLayout.setBackground(root);
			if(pListener!=null) {
				textButton.setOnClickListener(new View.OnClickListener() {
					@Override public void onClick(View view) {
						pListener.OnClick();
						alertDialog.dismiss();
					}
				});
			} else{
				textButton.setOnClickListener(new View.OnClickListener() {
					@Override public void onClick(View view) {
						alertDialog.dismiss();
					}
				});
			}
			
			
			alertDialog.setCancelable(this.canceled);
			alertDialog.show();
			return new MaterialDialog(this);
		}
	}
}
