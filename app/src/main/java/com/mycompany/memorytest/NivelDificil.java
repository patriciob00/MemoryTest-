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


public class NivelDificil extends Activity {

    private MediaPlayer fim , restart , click ,victory = null;
    private int fimJogo , contaBotton , placar = 0 ;
    Button voltar , reiniciar ;
    private int[] imgs= { R.drawable.cool , R.drawable.shout , R.drawable.icon_razz, R.drawable.spook
            , R.drawable.shout , R.drawable.prettiness, R.drawable.slobber, R.drawable.icon_lol
            , R.drawable.cool , R.drawable.shout , R.drawable.icon_razz, R.drawable.spook
            , R.drawable.shout , R.drawable.prettiness , R.drawable.slobber , R.drawable.icon_lol };

    ArrayList<Integer> cards = new ArrayList<>();
    ArrayList<Integer> imagem = new ArrayList<>();
    ArrayList<Integer>  btns  = new ArrayList<>();

    private int[] IDs = { R.id.bt1 , R.id.bt2 , R.id.bt3 , R.id.bt4
            , R.id.bt5 , R.id.bt6 , R.id.bt7 , R.id.bt8
            , R.id.bt9 , R.id.bt10 , R.id.bt11 , R.id.bt12
            , R.id.bt13 , R.id.bt14 , R.id.bt15 , R.id.bt16 , };

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.nivel_dificil );

        inicializarBotton();
        fillArray();
        botãoSetar();

    }

    public void inicializarBotton(){
        voltar = ( Button )findViewById( R.id.voltar);
        reiniciar = ( Button )findViewById( R.id.reiniciar);
    }

    public void botãoSetar(){
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
                AlertDialog.Builder alert = new AlertDialog.Builder( NivelDificil.this );
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
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder( NivelDificil.this );
                ad.setTitle( "Atenção !!!" );
                ad.setMessage( "Deseja realmente reiniciar o jogo ?" );
                ad.setPositiveButton( "Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restart();
                    }
                });
                ad.setNegativeButton( "Não" , null );
                ad.show();
            }
        });
    }

    public void restart() {
        for (int i = 0; i < IDs.length; i++) {
            ImageButton bt1 = (ImageButton) findViewById(IDs[i]);
            bt1.setClickable( true );
            bt1.setBackgroundResource(R.drawable.snoop_clown);
        }
        Collections.shuffle(cards);
        playRestart();
        fimJogo = 0;
        contaBotton = 0;
        placar = 0;
        if (fim != null) {
            fim.stop();
            fim.release();
            fim = null;
        }
    }

    public void isFim() {
        if ( fimJogo == 8 ){
            fim = MediaPlayer.create(NivelDificil.this, R.raw.bonus_results);
            fim.start();
            fim.setLooping( true );
            AlertDialog.Builder alertFim = new AlertDialog.Builder( NivelDificil.this );
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
                    restart();
                }
            });
            alertFim.show();

        }
    }

    public void click ( View v ){
        switch(((ImageButton)v).getId()){
            case R.id.bt1:
                (( ImageButton ) v ).setBackgroundResource( cards.get( 0 ));
                ++contaBotton;
                btns.add( R.id.bt1 );
                imagem.add( cards.get( 0 ) );
                break;
            case R.id.bt2:
                (( ImageButton ) v ).setBackgroundResource( cards.get( 1 ));
                ++contaBotton;
                btns.add( R.id.bt2 );
                imagem.add( cards.get( 1 ) );
                break;
            case R.id.bt3:
                (( ImageButton ) v ).setBackgroundResource( cards.get( 2 ));
                ++contaBotton;
                btns.add( R.id.bt3 );
                imagem.add( cards.get( 2 ) );
                break;
            case R.id.bt4 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 3 ));
                ++contaBotton;
                btns.add( R.id.bt4 );
                imagem.add( cards.get( 3 ) );
                break;
            case R.id.bt5 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 4 ));
                ++contaBotton;
                btns.add( R.id.bt5 );
                imagem.add( cards.get( 4 ) );
                break;
            case R.id.bt6 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 5 ));
                ++contaBotton;
                btns.add( R.id.bt6 );
                imagem.add( cards.get( 5 ) );
                break;
            case R.id.bt7 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 6 ));
                ++contaBotton;
                btns.add( R.id.bt7 );
                imagem.add( cards.get( 6 ) );
                break;
            case R.id.bt8 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 7 ));
                ++contaBotton;
                btns.add( R.id.bt8 );
                imagem.add( cards.get( 7 ) );
                break;
            case R.id.bt9:
                (( ImageButton ) v ).setBackgroundResource( cards.get( 8 ));
                ++contaBotton;
                btns.add( R.id.bt9 );
                imagem.add( cards.get( 8 ) );
                break;
            case R.id.bt10:
                (( ImageButton ) v ).setBackgroundResource( cards.get( 9 ));
                ++contaBotton;
                btns.add( R.id.bt10 );
                imagem.add( cards.get( 9 ) );
                break;
            case R.id.bt11:
                (( ImageButton ) v ).setBackgroundResource( cards.get( 10 ));
                ++contaBotton;
                btns.add( R.id.bt11 );
                imagem.add( cards.get( 10 ) );
                break;
            case R.id.bt12 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 11 ));
                ++contaBotton;
                btns.add( R.id.bt12 );
                imagem.add( cards.get( 11 ) );
                break;
            case R.id.bt13 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 12 ));
                ++contaBotton;
                btns.add( R.id.bt13 );
                imagem.add( cards.get( 12 ) );
                break;
            case R.id.bt14 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 13 ));
                ++contaBotton;
                btns.add( R.id.bt14 );
                imagem.add( cards.get( 13 ) );
                break;
            case R.id.bt15 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 14 ));
                ++contaBotton;
                btns.add( R.id.bt15 );
                imagem.add( cards.get( 14 ) );
                break;
            case R.id.bt16 :
                (( ImageButton ) v ).setBackgroundResource( cards.get( 15 ));
                ++contaBotton;
                btns.add( R.id.bt16 );
                imagem.add( cards.get( 15 ) );
                break;
        }
        playMusic();
        verificarPar( btns , imagem );
    }

    public void verificarPar( ArrayList<Integer> btn , ArrayList<Integer> img ){
        if ( contaBotton == 2 ) {
            ImageButton btn1 = ( ImageButton ) findViewById( btn.get( 0 ));
            ImageButton btn2 = ( ImageButton ) findViewById( btn.get( 1 ));
            int img1 = img.get( 0 );
            int img2 = img.get( 1 );
            int verif1 = btn.get( 0 );
            int verif2 = btn.get( 1 );

            if( img1 == img2 && verif1 != verif2 ){
                playVictory();
                btn1.setClickable( false );
                btn2.setClickable( false );
                placar +=30;
                fimJogo++;
                btn.clear();
                img.clear();
                contaBotton = 0 ;
                isFim();
            }else{
                final View view = ( ImageButton )findViewById( btn.get( 1 ));
                final View anterior = ( ImageButton )findViewById( btn.get( 0 ));
                view.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        view.setBackgroundResource( R.drawable.snoop_clown );
                        view.setClickable( true );

                        anterior.setBackgroundResource( R.drawable.snoop_clown );
                        anterior.setClickable( true );

                    }
                }, 1000 );
                btn.clear();
                img.clear();
                contaBotton = 0 ;
                if ( placar >= 10 ) {
                    placar -= 10;
                }
            }
        }
    }
    public void fillArray(){
        for ( int i = 0 ; i < imgs.length ; i++ ){
            cards.add( imgs[ i ] ) ;
        }
    }
    public void playRestart(){
        restart = MediaPlayer.create( NivelDificil.this , R.raw.restarts );
        restart.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer restart ) {
                restart.stop();
                restart.release();
                restart = null;
            }

        });
        restart.start();
    }

    public void playVictory() {
        victory = MediaPlayer.create(NivelDificil.this, R.raw.goal);
        victory.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer victory) {
                victory.stop();
                victory.release();
                victory = null;
            }
        });
        victory.start();
    }

    public void playMusic() {
        click = MediaPlayer.create(NivelDificil.this, R.raw.click);
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
        AlertDialog.Builder alert = new AlertDialog.Builder( NivelDificil.this );
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

