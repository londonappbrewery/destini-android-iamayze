package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView t1;
    Button b1,b2;

    int mStoryIndex;
    //this value is to check whether the game reached the end so that the AlertDialogue Box will appear
    boolean Chkend;

    public Questions[] QAdata =  new Questions[]{

            //id0
            new Questions(R.string.T1_Story , R.string.T1_Ans1 , R.string.T1_Ans2),
            //id1
            new Questions(R.string.T2_Story , R.string.T2_Ans1 , R.string.T2_Ans2),
            //id2
            new Questions(R.string.T3_Story , R.string.T3_Ans1 , R.string.T3_Ans2),
            //id3
            //Created an extra string called nil , whenever the game reaches the end the button text changes to THE END
            new Questions(R.string.T4_End , R.string.nil , R.string.nil),
            //id4
            new Questions(R.string.T5_End , R.string.nil , R.string.nil),
           //id5
            new Questions(R.string.T6_End , R.string.nil , R.string.nil)

           };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1= findViewById(R.id.storyTextView);
        b1 = findViewById(R.id.buttonTop);
        b2= findViewById(R.id.buttonBottom);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
              t1.setText(QAdata[mStoryIndex].getQuestions());
              b1.setText(QAdata[mStoryIndex].getAnswers());
              b2.setText(QAdata[mStoryIndex].getAnswers2());


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 //If the game reached the end . Chkend will be true then it will run the theend function
                 if (Chkend == true) {
                     theend();
                 } else {
                     whenButtonClickTop();
                 }
             }
         });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
     b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             if(Chkend==true)
             {
                 theend();
             }

             whenButtonClickBottom();

         }
     });

    }
    //This method is to make the app to pop-up a ALERTDIALOGUE text whenever the game reach the final route
    void theend()
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("THE END");
        alert.setCancelable(false);
        alert.setMessage("The Game Is Over .... Click To Exit The Application");
        alert.setNegativeButton("Close AppliCation", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             finish();
            }
        });
        alert.show();
        }



//when the top button is called
    void whenButtonClickTop()
    {
          if(mStoryIndex == 0 || mStoryIndex==1)
          {
              mStoryIndex =2;

          }
        else if(mStoryIndex==2)
          {
              mStoryIndex=5;
              Chkend = true;

          }


        t1.setText(QAdata[mStoryIndex].getQuestions());
        b1.setText(QAdata[mStoryIndex].getAnswers());
        b2.setText(QAdata[mStoryIndex].getAnswers2());

    }

    // when the bottom button is called
    void whenButtonClickBottom()
    {
        if(mStoryIndex==2)
        {
            mStoryIndex=4;
            Chkend=true;


        }
        else if(mStoryIndex==0)
        {
           mStoryIndex=1;
        }
        else if(mStoryIndex==1)
        {
            mStoryIndex=3;
            Chkend=true;

        }

        t1.setText(QAdata[mStoryIndex].getQuestions());
        b1.setText(QAdata[mStoryIndex].getAnswers());
        b2.setText(QAdata[mStoryIndex].getAnswers2());

    }


}
