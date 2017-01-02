package cn.edu.gdmec.s07150638.alertdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.s07150638.alertdialog.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8;
    private TextView tView;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("AlertDialog");
        init();
    }

    private void init(){
        tView = (TextView)findViewById(R.id.textView1);
        bt1 = (Button)findViewById(R.id.button1);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
        bt4 = (Button)findViewById(R.id.button4);
        bt5 = (Button)findViewById(R.id.button5);
        bt6 = (Button)findViewById(R.id.button6);
        bt7 = (Button)findViewById(R.id.button7);
        bt8 = (Button)findViewById(R.id.button8);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
    }

    public void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE) {//按下确定
                    dialog.dismiss();
                    //MainActivity.this.finish();
                    System.exit(0);
                }else if(which == DialogInterface.BUTTON_NEGATIVE){//按下取消
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }

    public void dialog2(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "平时一般";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时轻松";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"平时很忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"平时一般",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"平时轻松",listener);
        dialog.show();
    }

    public void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText editText = new EditText(this);
        editText.setMaxLines(1);
        dialog.setView(editText);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+editText.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    public void dialog4(){
        final String item[]={"北京","广州","上海"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //用一个数组记录选择的所以选项
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListener);
        dialog = builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for(int i = 0 ;i < item.length; i++){
                    if(bSelect[i]){
                        str = str + "\n" + item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    public void dialog5(){
        final String[]item = {"北京","广州","上海"};
        final boolean[] bSelect = new boolean[item.length];
        DialogInterface.OnClickListener sListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which] = true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListener);
        dialog = builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for(int i = 0;i<item.length;i++){
                    if(bSelect[i]){
                        str = str + "\n" + item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    public void dialog6(){
        final String item[] ={"北京","上海","广州"};
        final boolean[] bSelect = new boolean[item.length];
        DialogInterface.OnClickListener sListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了" + item[which];
                tView.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,sListener);
        dialog = builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"取消",listener);
        dialog.show();
    }

    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit = (EditText)layout.findViewById(R.id.editText1);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }

    private void dialog8(){
        Intent intent = new Intent(MainActivity.this,MenuDemo.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                dialog1();
                break;
            case R.id.button2:
                dialog2();
                break;
            case R.id.button3:
                dialog3();
                break;
            case R.id.button4:
                dialog4();
                break;
            case R.id.button5:
                dialog5();
                break;
            case R.id.button6:
                dialog6();
                break;
            case R.id.button7:
                dialog7();
                break;
            case R.id.button8:
                dialog8();
                break;
        }
    }
}
