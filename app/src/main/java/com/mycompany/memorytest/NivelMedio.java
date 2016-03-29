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


public class NivelMedio extends Activity {
    private int fimJogo , contaBotton , placar  = 0;
    Button reiniciar , voltar ;
    private MediaPlayer click , Final , Victory , fim = null;

    private final int[] ids = { R.id.b1 , R.id.b2 , R.id.b3 , R.id.b4
            , R.id.b5 , R.id.b6 , R.id.b7 , R.id.b8
            , R.id.b9 , R.id.b10 , R.id.b11 , R.id.b12 };

    private final int[] imgs = {R.drawable.icon_lovely, R.drawable.icon_heart
            , R.drawable.spook, R.drawable.icon_razz
            , R.drawable.cool, R.drawable.shout
            , R.drawable.icon_lovely, R.drawable.icon_heart
            , R.drawable.spook, R.drawable.icon_razz
            , R.drawable.cool, R.drawable.shout};

    private ArrayList<Integer> cards  = new ArrayList<>();
    private ArrayList<Integer> buttons = new ArrayList<>();
    private ArrayList<Integer> imagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nivel_medio);

        inicializarBotton();
        setarBotton();
        fillArray(cards, imgs);
        Collections.shuffle(cards);
    }

    public void inicializarBotton() {
        voltar = (Button) findViewById(R.id.voltar);
        reiniciar = (Button) findViewById(R.id.reinicioMd);
    }

    public void setarBotton() {
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
                playMusic();
                AlertDialog.Builder alert = new AlertDialog.Builder( NivelMedio.this );
                alert.setTitle( "Atenção !!!" );
                alert.setMessage( "Deseja realmente sair do jogo ?" );
                alert.setPositiveButton( "Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.setNegativeButton( "Não" , null );
                alert.show();
            }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder( NivelMedio.this );
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

    public void playMusic() {
        click = MediaPlayer.create(NivelMedio.this, R.raw.click);
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

    public void playVictory() {
        Victory = MediaPlayer.create(NivelMedio.this, R.raw.goal);
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

    public void playRestart() {
        Final = MediaPlayer.create(NivelMedio.this, R.raw.restarts);
        Final.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer Final) {
                Final.stop();
                Final.release();
                Final = null;
            }
        });
        Final.start();
    }

    public void fillArray(ArrayList list, int[] img) {
        for (int i = 0; i < img.length; i++) {
            list.add(img[i]);
        }
    }

    public void verificaPar(ArrayList<Integer> buttons, ArrayList<Integer> imagens) {
        if ( contaBotton == 2 ) {
            ImageButton btn1 = ( ImageButton ) findViewById( buttons.get( 0 ));
            ImageButton btn2 = ( ImageButton ) findViewById( buttons.get( 1 ));
            int img1 = imagens.get( 0 );
            int img2 = imagens.get( 1 );
            int verif1 = buttons.get( 0 );
            int verif2 = buttons.get( 1 );

            if( img1 == img2 && verif1 != verif2 ){
                playVictory();
                btn1.setClickable( false );
                btn2.setClickable( false );
                placar +=30;
                fimJogo++;
                buttons.clear();
                imagens.clear();
                contaBotton = 0 ;
                isFim();
            }else{
                final View view = ( ImageButton )findViewById( buttons.get( 1 ));
                final View anterior = ( ImageButton )findViewById( buttons.get( 0 ));
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.setBackgroundResource(R.drawable.snoop_pilot);
                        view.setClickable(true);

                        anterior.setBackgroundResource(R.drawable.snoop_pilot);
                        anterior.setClickable(true);

                    }
                }, 1000);
                buttons.clear();
                imagens.clear();
                contaBotton = 0 ;
                if ( placar >= 10 ) {
                    placar -= 10;
                }
            }
        }
    }

    public void clickView( View v ){
        switch ((( ImageButton )v ).getId() ){
            case R.id.b1:
                (( ImageButton ) v ).setBackgroundResource(( int ) cards.get( 0 ));
                ++contaBotton;
                buttons.add( R.id.b1 );
                imagens.add( cards.get( 0 ) );
                break;
            case R.id.b2:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 1 ));
                ++contaBotton;
                buttons.add( R.id.b2);
                imagens.add( cards.get( 1 ));
                break;
            case R.id.b3:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 2 ));
                ++contaBotton;
                buttons.add( R.id.b2);
                imagens.add( cards.get( 2 ));
                break;
            case R.id.b4:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 3 ));
                ++contaBotton;
                buttons.add( R.id.b4);
                imagens.add( cards.get( 3 ));
                break;
            case R.id.b5:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 4 ));
                ++contaBotton;
                buttons.add( R.id.b5);
                imagens.add( cards.get( 4 ));
                break;
            case R.id.b6:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 5 ));
                ++contaBotton;
                buttons.add( R.id.b6);
                imagens.add( cards.get( 5 ));
                break;
            case R.id.b7:
                (( ImageButton ) v ).setBackgroundResource(( int ) cards.get( 6 ));
                ++contaBotton;
                buttons.add( R.id.b7 );
                imagens.add( cards.get( 6 ) );
                break;
            case R.id.b8:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 7 ));
                ++contaBotton;
                buttons.add( R.id.b8);
                imagens.add( cards.get( 7 ));
                break;
            case R.id.b9:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 8 ));
                ++contaBotton;
                buttons.add( R.id.b9);
                imagens.add( cards.get( 8 ));
                break;
            case R.id.b10:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 9 ));
                ++contaBotton;
                buttons.add( R.id.b10);
                imagens.add( cards.get( 9 ));
                break;
            case R.id.b11:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 10 ));
                ++contaBotton;
                buttons.add( R.id.b11);
                imagens.add( cards.get( 10 ));
                break;
            case R.id.b12:
                (( ImageButton ) v ).setBackgroundResource( ( int ) cards.get( 11 ));
                ++contaBotton;
                buttons.add( R.id.b12);
                imagens.add( cards.get( 11 ));
                break;
        }
        playMusic();
        verificaPar( buttons , imagens );
    }

    public void restart(){

        for ( int i = 0 ; i < ids.length ; i++ ){
            ImageButton bt1 = (ImageButton) findViewById(ids[i]);
            bt1.setClickable(true);
            bt1.setBackgroundResource(R.drawable.snoop_pilot);
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
        if ( fimJogo == 6 ){
            fim = MediaPlayer.create( NivelMedio.this , R.raw.bonus_results );
            fim.start();
            fim.setLooping( true );
            AlertDialog.Builder alertFim = new AlertDialog.Builder( NivelMedio.this );
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
        AlertDialog.Builder alert = new AlertDialog.Builder( NivelMedio.this );
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
