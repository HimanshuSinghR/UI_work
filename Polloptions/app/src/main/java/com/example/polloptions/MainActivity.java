package com.example.polloptions;

import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.polloptions.Model.progressBar_Class;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.nio.DoubleBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int total_votes;
    private ArrayList <ProgressBar> progresslist;
    private ArrayList <progressBar_Class> option_list;
    private ProgressBar progressBar;
    private ArrayList <TextView> percentlist;
    private TextView percentbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllprogressbars();
        option_list = new ArrayList<>();
        total_votes = 0;



        for ( int i = 0; i < progresslist.size() ;i++ ){

            progressBar_Class opt = new progressBar_Class();

            progressBar = findViewById( progresslist.get(i).getId() );
            percentbox = findViewById( percentlist.get(i).getId() );
            progressBar.setOnClickListener(this);
            opt.setBar_count(0);
            opt.setProgressBar(progressBar);
            opt.setId( progresslist.get(i).getId() );
            opt.setPercentbox( percentbox );
            option_list.add(opt);

        }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        for(int i = 0; i < option_list.size();i++ ) {
            if ( v.getId() == option_list.get(i).getId() ) {

                option_list.get(i).setBar_count(option_list.get(i).getBar_count()+1);
                total_votes = total_votes + 1;
                option_list.get(i).getProgressBar().setProgressDrawable(getResources().getDrawable(R.drawable.selected_progressbar));
                setup_UI(option_list);
            }
            else{
               option_list.get(i).getProgressBar().setProgressDrawable(getResources().getDrawable(R.drawable.custom_progressbar));
            }
        }


    }

    public void getAllprogressbars(){

        percentlist = new ArrayList<>();
        ViewGroup parent = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_main, null);
        progresslist = new ArrayList<>();

        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {

            if ( parent.getChildAt(i) instanceof RelativeLayout) {
                ViewGroup viewgroup = (ViewGroup) parent.getChildAt(i);

                int child_count = viewgroup.getChildCount();
                for( int j = 0;j < child_count; j++ ) {
                    View view = (View) viewgroup.getChildAt(j);

                    if ( view instanceof ProgressBar ) {
                        progresslist.add((ProgressBar) view);
                    }
                    if ( view instanceof AppCompatTextView ) {
                        AppCompatTextView prtext = (AppCompatTextView) view;

                        String text = prtext.getText().toString();

                        if ( text.equals("0") ) {
                            percentlist.add( prtext );


                        }
                    }
                }
            }
        }
    }

    public void setup_UI(ArrayList<progressBar_Class> list){
        for( int i = 0; i < list.size();i++ ) {

            Double votes = Double.valueOf(total_votes);
            Double prcnt = Double.valueOf(option_list.get(i).getBar_count())/votes;
            DecimalFormat df = new DecimalFormat("0.00");
            int value  = (int) Math.round(prcnt*100);
            list.get(i).getProgressBar().setProgress(value);
            list.get(i).getPercentbox().setText(df.format(prcnt*100));


        }
    }

}