package cn.edu.gdmec.s07150638.alertdialog;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuDemo extends AppCompatActivity{

    private Button bt1;
    private Button bt2;
    private Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AlertDialog");
        setContentView(R.layout.menu_main);
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);
        bt3 = (Button) findViewById(R.id.bt_3);
        registerForContextMenu(bt1);
        registerForContextMenu(bt2);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDemo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add("一个参数的add方法创建的菜单项1");
//        menu.add("一个参数的add方法创建的菜单项2");
//        menu.add(1,Menu.NONE,Menu.NONE,R.string.itemtitle1);
//        menu.add(1,Menu.NONE,Menu.NONE,R.string.itemtitle2);
        menu.add(Menu.NONE,1,Menu.NONE,"添加");
        menu.add(Menu.NONE,2,Menu.NONE,"删除");
        menu.add(Menu.NONE,3,Menu.NONE,"保存").setIcon(android.R.drawable.ic_menu_edit);
        menu.add(Menu.NONE,4,Menu.NONE,"退出");
        SubMenu file = menu.addSubMenu("文件");
//        SubMenu edit = menu.addSubMenu("编辑");
        file.add(0,5,0,"新建");
        file.add(0,6,0,"打开");

//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch(v.getId()){
            case R.id.bt_1:
                menu.add(0,1,0,"菜单项1");
                menu.add(0,2,0,"菜单项2");
                menu.add(0,3,0,"菜单项3");
                break;
            case R.id.bt_2:
                menu.add(0,4,0,"菜单项4");
                menu.add(0,5,0,"菜单项5");
                menu.add(0,6,0,"菜单项6");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                Log.i("Tag","哈哈");
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                //Log.i("Tag11","哈哈1");
                break;
            case 2:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                break;
            case 5:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                bt1.setText("菜单项1");
                break;
            case 2:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                bt1.setText("菜单项2");
                break;
            case 3:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                bt1.setText("菜单项3");
                break;
            case 4:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                bt2.setText("菜单项4");
                break;
            case 5:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                bt2.setText("菜单项5");
                break;
            case 6:
                Toast.makeText(MenuDemo.this,"选择了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                bt2.setText("菜单项6");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
