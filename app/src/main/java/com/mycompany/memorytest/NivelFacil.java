package com.mycompany.memorytest;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;


public class NivelFacil extends Activity{
    private int fimJogo , contaBotton , placar  = 0 ;
    private Button reiniciar , voltar ;
    private MediaPlayer Victory , restart , fim , click = null ;

    private final int[] ids = { R.id.btn1 , R.id.btn2 , R.id.btn3 , R.id.btn4
                              , R.id.btn5 , R.id.btn6 , R.id.btn7 , R.id.btn8 };

    private final int[] imgs = {R.drawable.cool,R.drawable.confused
                               ,R.drawable.prettiness,R.drawable.slobber
                               ,R.drawable.cool,R.drawable.confused
                               ,R.drawable.prettiness,R.drawable.slobber} ;

    private ArrayList<Integer> imagem = new ArrayList<>() ;
    private ArrayList<Integer> cards = new ArrayList<>() ;
    private ArrayList<Integer> botton  = new ArrayList<>() ;



    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
          setContentView( R.layout.nivel_facil );
          iniciarBotton();
          onclickBotton();
          fillarray();
          Collections.shuffle( cards );
    }

    public void iniciarBotton(){
        voltar =( Button )findViewById( R.id.voltar );
        reiniciar =( Button )findViewById( R.id.reiniciar );
    }
    public void onclickBotton(){
        voltar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                playMusic();
                AlertDialog.Builder alert = new AlertDialog.Builder( NivelFacil.this );
                alert.setTitle( "Atenção !!!" );
                alert.setMessage( "Deseja realmente sair do jogo ?" );
                alert.setPositiveButton( "Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.setNegativeButton("Não", null);
                alert.show();
            }
        });

        reiniciar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder( NivelFacil.this );
                ad.setTitle( "Atenção !!!" );
                ad.setMessage( "Deseja realmente reiniciar o jogo ?" );
                ad.setPositiveButton( "Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restarts();
                    }
                });
                ad.setNegativeButton( "Não" , null );
                ad.show();
            }
        });
    }

    public void clickView( View v  ){
        switch((( ImageButton )v ).getId()){
            case R.id.btn1:
                ( v ).setBackgroundResource( cards.get(0));
                ++contaBotton;
                botton.add(R.id.btn1);
                imagem.add(cards.get(0));
                break;
            case R.id.btn2:
                ( v ).setBackgroundResource( cards.get(1));
                ++contaBotton;
                botton.add(R.id.btn2);
                imagem.add(cards.get(1));
                break;
            case R.id.btn3:
                ( v ).setBackgroundResource( cards.get(2));
                ++contaBotton;
                botton.add(R.id.btn3);
                imagem.add(cards.get(2));
                break;
            case R.id.btn4:
                ( v ).setBackgroundResource( cards.get(3));
                ++contaBotton;
                botton.add(R.id.btn4);
                imagem.add(cards.get(3));
                break;
            case R.id.btn5:
                ( v ).setBackgroundResource( cards.get(4));
                ++contaBotton;
                botton.add(R.id.btn5);
                imagem.add(cards.get(4));
                break;
            case R.id.btn6:
                ( v ).setBackgroundResource( cards.get(5));
                ++contaBotton;
                botton.add(R.id.btn6);
                imagem.add(cards.get(5));
                break;
            case R.id.btn7:
                ( v ).setBackgroundResource( cards.get(6));
                ++contaBotton;
                botton.add(R.id.btn7);
                imagem.add(cards.get(6));
                break;
            case R.id.btn8:
                ( v ).setBackgroundResource( cards.get(7));
                ++contaBotton;
                botton.add(R.id.btn8);
                imagem.add(cards.get(7));
                break;
        }
        playMusic();
        verificaPar(botton ,imagem);
    }

    public void fillarray(){
        for (int i =0; i <imgs.length ; i++)
            cards.add(imgs[i]);
    }

    public void playMusic(){
        click = MediaPlayer.create( NivelFacil.this,R.raw.click );
        click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer click) {
                click.stop();
                click.release();
                click = null;
            }
        });
        click.start();
    }
    public void playVictory(){
        Victory = MediaPlayer.create( NivelFacil.this,R.raw.goal );
        Victory.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer Victory) {
                Victory.stop();
                Victory.release();
                Victory = null;
            }
        });
        Victory.start();
    }

    public void playRestart(){

        restart = MediaPlayer.create( NivelFacil.this,R.raw.restarts );
        restart.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion( MediaPlayer restart ) {
                restart.stop();
                restart.release();
                restart = null;
            }
        });
        restart.start();
    }

    public void verificaPar(ArrayList<Integer> botton , ArrayList<Integer> imagem ){
        if ( contaBotton == 2 ) {
            ImageButton btn1 = ( ImageButton ) findViewById( botton.get( 0 ));
            ImageButton btn2 = ( ImageButton ) findViewById( botton.get( 1 ));
            int img1 = imagem.get( 0 );
            int img2 = imagem.get( 1 );
            int verif1 = botton.get( 0 );
            int verif2 = botton.get( 1 );

            if( img1 == img2 && verif1 != verif2 ){
                playVictory();
                btn1.setClickable( false );
                btn2.setClickable( false );
                placar +=30;
                fimJogo++;
                botton.clear();
                imagem.clear();
                contaBotton = 0 ;
                isFim();
            }else{
                final View view = ( ImageButton )findViewById( botton.get( 1 ));
                final View anterior = ( ImageButton )findViewById( botton.get( 0 ));
                view.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        view.setBackgroundResource( R.drawable.snoop_vamp );
                        view.setClickable( true );

                        anterior.setBackgroundResource( R.drawable.snoop_vamp );
                        anterior.setClickable( true );

                    }
                }, 1000 );
                botton.clear();
                imagem.clear();
                contaBotton = 0 ;
                if ( placar >= 10 ) {
                    placar -= 10;
                }
            }
        }
    }
    public void restarts(){
        for ( int i = 0 ; i < ids.length ; i++ ){
            ImageButton bt1  = ( ImageButton )findViewById( ids[i] );
            bt1.setClickable( true );
            bt1.setBackgroundResource( R.drawable.snoop_vamp );
        }
        Collections.shuffle( cards );
        playRestart();
        fimJogo = 0 ;
        contaBotton = 0 ;
        placar = 0 ;
        if ( fim != null ){
            fim.stop();
            fim.release();
            fim = null ;
        }
    }

    public void isFim() {
        if ( fimJogo == 4 ){
            fim = MediaPlayer.create( NivelFacil.this , R.raw.bonus_results );
            fim.start();
            fim.setLooping( true );
            AlertDialog.Builder alertFim = new AlertDialog.Builder( NivelFacil.this );
            alertFim.setTitle( "Fim de Jogo !" );
            alertFim.setMessage( "Parabéns !!!! \n Sua pontuação :" + placar + " . " );
            alertFim.setPositiveButton( "Sair" , new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertFim.setNegativeButton( "Reiniciar" , new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    restarts();
                }
            });
            alertFim.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (fim != null){
            fim.stop();
            fim.release();
            fim = null;
        }
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alert = new AlertDialog.Builder( NivelFacil.this );
        alert.setTitle( "Atenção !!!" );
        alert.setMessage( "Deseja realmente sair do jogo ?" );
        alert.setPositiveButton( "Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("Não", null);
        alert.show();

    }
}
