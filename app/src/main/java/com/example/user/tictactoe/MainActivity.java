package com.example.user.tictactoe;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int[][] a=new int[4][4];
    public int i;
    public int j;
    public int turn;
    public int score1,score2;
    ImageView[][] iv= new ImageView[4][4];
    ImageView[] w = new ImageView[4];
    TextView t;

    public int cnt1,cnt2;
    public void update()
    {
        int flag=0;



           for(i=1;i<=3;i++) {
               for (j = 1; j <= 3; j++) {

                   if (a[i][j] == 0)
                   {    flag=1;
                       iv[i][j].setImageResource(R.drawable.box);
                   }
                   else if (a[i][j] == 1)
                   {
                       iv[i][j].setImageResource(R.drawable.round);

                   }
                   else if (a[i][j] == 2)
                   {
                       iv[i][j].setImageResource(R.drawable.ex);
                   }
               }
           }
        if(flag==0)
        {
            t.setText("Draw");
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    reset();
                }
            }, 2000);

        }
    }
    public void reset()
    {
        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
                a[i][j]=0;
        t.setText(" ");
        update();
    }
    public void update_score()
    {
        TextView sc1 = (TextView)(findViewById(R.id.score1));
        TextView sc2 = (TextView)(findViewById(R.id.score2));
        String s=Integer.toString(score1);
        sc1.setText(s);
        s=Integer.toString(score2);
        sc2.setText(s);

        for(int k=1;k<4;k++)
        {
            w[k].setImageResource(R.drawable.star);
        }


    }

    void win1()
    {
        t.setText("player1 won!!!");
        score1++;
        update_score();
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                reset();
            }
        }, 2000);

    }
    void win2()
    {
        t.setText("player2 won!!!");
        score2++;
        update_score();
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                reset();
            }
        }, 2000);

    }

    public void check()
    {

            cnt1=0;cnt2=0;

            for(i=1;i<4;i++)
            {
                cnt1=0;cnt2=0;

                for(j=1;j<4;j++)
                {
                    if(a[i][j]==1)
                        cnt1++;
                    else if(a[i][j]==2)
                        cnt2++;
                }

                if(cnt1==3||cnt2==3)
                {
                    for(int k=1;k<4;k++)
                        w[k]=iv[i][k];

                }

                if(cnt1==3) {


                    win1();
                }else if(cnt2==3) {


                    win2();

                }
            }


            for(j=1;j<4;j++)
            {
                cnt1=0;cnt2=0;
                for(i=1;i<4;i++)
                {
                    if(a[i][j]==1)
                        cnt1++;
                    else if(a[i][j]==2)
                        cnt2++;
                }
                if(cnt1==3||cnt2==3)
                {
                    for(int k=1;k<4;k++)
                        w[k]=iv[k][j];

                }

                if(cnt1==3)
                    win1();
                else if(cnt2==3)
                    win2();
            }

            cnt1=0;cnt2=0;
            for(i=1;i<=3;i++)
                if(a[i][i]==1)
                    cnt1++;
                else if(a[i][i]==2)
                    cnt2++;

            if(cnt1==3||cnt2==3)
            {

                    for(int k=1;k<4;k++)
                        w[k]=iv[k][k];

            }

            if(cnt1==3)
                win1();
            else if(cnt2==3)
                win2();

            cnt1=0;cnt2=0;
            for(i=1;i<=3;i++)
                if(a[i][4-i]==1)
                    cnt1++;
                else if(a[i][4-i]==2)
                    cnt2++;

            if(cnt1==3||cnt2==3)
            {

                for(int k=1;k<4;k++)
                    w[k]=iv[k][4-k];

            }



            if(cnt1==3)
                win1();
            else if(cnt2==3)
                win2();



    }


    public void box_click(View v)
    {
        String s=(String)((v.getTag()).toString());

         i=Character.getNumericValue(s.charAt(0));
         j=Character.getNumericValue(s.charAt(1));

         if(a[i][j]==0)
         {

             if(turn%2!=0) {
                 a[i][j] = 1;
                 t.setText("player 2");
             }
             else {
                 a[i][j] = 2;
                 t.setText("player 1");
             }

             update();
             check();
             turn++;
         }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        iv[1][1]=(ImageView)findViewById(R.id.iv11);
        iv[1][2]=(ImageView)findViewById(R.id.iv12);
        iv[1][3]=(ImageView)findViewById(R.id.iv13);
        iv[2][1]=(ImageView)findViewById(R.id.iv21);
        iv[2][2]=(ImageView)findViewById(R.id.iv22);
        iv[2][3]=(ImageView)findViewById(R.id.iv23);
        iv[3][1]=(ImageView)findViewById(R.id.iv31);
        iv[3][2]=(ImageView)findViewById(R.id.iv32);
        iv[3][3]=(ImageView)findViewById(R.id.iv33);





        score1=0;
        score2=0;
        i=0;j=0;
        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
                a[i][j]=0;

        turn=1;
        t = (TextView)(findViewById(R.id.textView2));

    }

}
