package t3.henu.left_library;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import t3.henu.left_library.Services.PlayService;

public class MainActivity extends AppCompatActivity {
    public static enum play_status{IS_PLAY,STOP};
    private FrameLayout mContentContainer;
    private View mFloatView;
    protected Context mContext;
    private ImageButton btn_play;
    public static PlayService.playBinder playBinder;
    public static ServiceConnection con=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            playBinder= (PlayService.playBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        mContext = this;
        ViewGroup mDecorView = (ViewGroup) getWindow().getDecorView();
        mContentContainer = (FrameLayout) ((ViewGroup) mDecorView.getChildAt(0)).getChildAt(1);
        mFloatView =  LayoutInflater.from(getBaseContext()).inflate(R.layout.flowplaymusic, null);

    }




    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity= Gravity.BOTTOM;
        mContentContainer.addView(mFloatView, layoutParams);

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * ��������activityʱû�ж���
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
       // intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        super.startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(0, 0);
    }
}
