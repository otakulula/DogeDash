
import ddf.minim.AudioPlayer;
        import ddf.minim.Minim;
        import processing.core.PApplet;
        import processing.core.PImage;
        import java.util.ArrayList;

public class GamePlay extends PApplet {
        int second = 0;
        static int minute = 0;
        final int finishedGame = 4;
        final int NORMAL_GAMEPLAY = 2;
        final int GAME_OVER = 3;
        final int STARTING = 1;
        int mode = STARTING;
        int timer;
        boolean spaceBarIsPressed = false;
        float groundX, groundY;

        ArrayList<SpikeLayout> oneSpikeListFORWallPaper1, threesSpikeListFORWallPaper1, threeSpikeFORWallPaper2, threeSpikeFORWallPaper3;
        SpikeLayout spikeOne, spikeThrees, soManySpikes, spikey, spiking,meanSpike,hiddenSpike,
                threeSpike1, threeSpike2, threeSpike3, threeSpike4, threeSpike5,threeSpike6,threeSpike7,threeSpike8,threeSpike9, threeSpike10,
                oneSpike1, oneSpike2, oneSpike3, oneSpike4,oneSpike5, oneSpike6,oneSpike7, oneSpike8,
                insideSpike1, insideSpike2;
        ArrayList<BlockLayout> FloorBlocksFORWallPaper2,
                CityBlocksFORWallPaper4HIGHDOWN, CityBlocksFORWallPaper4MIDDLEDOWN, CityBlocksFORWallPaper4LOWDOWN,
                CityBlocksFORWallPaper4MIDDLEUP, CityBlocksFORWallPaper4HIGHUP, CityBlocksFORWallPaper4LOWUP;

        BlockLayout FloorBlock1, FloorBlock2, FloorBlock3, FloorBlock4, FloorBlock5, FloorBlock6, FloorBlock7, FloorBlock8, FloorBlock9, LongFloorBlock1, LongFloorBlock2,LongFloorBlock3,
                floorBlock10,floorBlock11,floorBlock12,floorBlock13, floorBlock14,floorBlock15,floorBlock16,floorBlock17,floorBlock18,floorBlock19,floorBlock20,floorBlock21,floorBlock22,floorBlock23, floorBlock24, floorBlock25,
                dogeCityBlocksHIGHDOWN, dogeCityBlocksMIDDLEDOWN, dogeCityBlocksLOWDOWN,
                dogeCityBlocksMIDDLEUP, dogeCityBlocksHIGHUP, dogeCityBlocksLOWUP;
        PlayerLayout user1;

        PortalLayout portal1, portal2;

        PImage UserIcon,
                OneSpike, threeSpikes, manySpikes,
                StartScreen, GameOver, FinishedGame,
                wallPaper1, wallPaper2, wallPaper3, wallPaper4, wallPaper5,
                portal, downPortal,
                dogeBlockHighDown, dogBlockMiddleDown, dogBlockLowDown, dogBlockMiddleUp, dogBlockHighUp, dogBlockLowUp,
                dogeFloorBlock1, dogeFloorBlock2, dogeFloorBLock3, dogeFloorBlock4, dogeFloorBlock5,dogeFloorBlock6, dogeFloorBlock7, dogeFloor10, dogFloor20,
                dogeLongFloorBlock1, dogeLongFloorBlock2;

        PImage [] gifList;
        Minim loader;
        AudioPlayer song;
        AudioPlayer oofNoise;

        public void settings() {
                size(1190, 835);
        }

        public void setup() {
                user1 = new PlayerLayout(96, 660, 60, 60, 0, 1);
                oneSpikeListFORWallPaper1 = new ArrayList<>();
                for (int i = 0; i < 8; i++) {
                        spikeOne = new SpikeLayout((200 * i) + 690, 710, 40, 40, -5, user1);
                        oneSpikeListFORWallPaper1.add(spikeOne);
                }
                threesSpikeListFORWallPaper1 = new ArrayList<>();
                for (int i = 0; i < 7; i++) {
                        spikeThrees = new SpikeLayout((350 * i) + 2420, 705, 75, 45, -5, user1);
                        threesSpikeListFORWallPaper1.add(spikeThrees);
                }

                FloorBlocksFORWallPaper2 = new ArrayList<>();
                for( int i = 1; i <4; i ++){
                        FloorBlock1 = new BlockLayout((325* i)+ 2400, 310, 110, 90, -6, user1);
                        FloorBlocksFORWallPaper2.add(FloorBlock1);
                }
                threeSpikeFORWallPaper2 = new ArrayList<>();
                for(int i = 0; i < 60; i ++){
                        soManySpikes = new SpikeLayout((75 * i) + 700, 705, 75, 45, -6, user1);
                        threeSpikeFORWallPaper2.add(soManySpikes);
                }

                spikey= new SpikeLayout(4805,555, 40, 40, -6, user1);

                FloorBlock2 = new BlockLayout(770,590,120,90,-6,user1);
                FloorBlock3 = new BlockLayout( 990, 520,110,90,-6,user1);
                FloorBlock4 = new BlockLayout( 1210, 450,110,90,-6,user1);
                FloorBlock5 = new BlockLayout( 1430, 380,110,90,-6, user1);
                FloorBlock6 = new BlockLayout(1650,310,110,90,-6,user1);
                FloorBlock7 = new BlockLayout( 4610, 590, 70,90,-6,user1);
                FloorBlock8 = new BlockLayout(4805, 590,110,90,-6, user1);
                FloorBlock9 = new BlockLayout( 5020, 520,110,90,-6,user1);
                LongFloorBlock1 = new BlockLayout( 1870, 240,690,90,-6,user1);
                LongFloorBlock2 = new BlockLayout(3650,170,690,90,-6,user1);

                threeSpike1 = new SpikeLayout(550 ,705,75,45,-7,user1);
                floorBlock10 = new BlockLayout( 850, 650, 40, 100,-7, user1);
                oneSpike1 = new SpikeLayout( 850,615,40,40,-7,user1);
                insideSpike1 = new SpikeLayout( 850,650,40,40,-7, user1);
                threeSpike2 = new SpikeLayout( 1150, 705,75,45, -7, user1);
                floorBlock11 = new BlockLayout( 1450, 650,40,100,-7, user1);
                oneSpike2 = new SpikeLayout( 1450, 615,40, 40, -7, user1);
                insideSpike2 = new SpikeLayout( 1450,650,40,40,-7,user1);
                oneSpike3 = new SpikeLayout( 1750, 710, 40,  40, -7, user1);
                floorBlock12= new BlockLayout( 1800,650,110,90,-7,user1);
                threeSpike3 = new SpikeLayout(1910, 705,75,45,-7, user1);
                threeSpike4 = new SpikeLayout(2275, 705,75,45,-7,user1);
                threeSpike5 = new SpikeLayout( 2560, 705,75,45,-7,user1);
                threeSpikeFORWallPaper3 = new ArrayList<>();
                for(int i = 0; i < 45; i ++){
                        spiking = new SpikeLayout((75 * i) + 2725, 705, 75, 45, -7, user1);
                        threeSpikeFORWallPaper3.add(spiking);
                }
                floorBlock13 = new BlockLayout(2700, 650,40,100,-7,user1);
                threeSpike6 = new SpikeLayout(2860,607,75,45,-7,user1);
                floorBlock14 = new BlockLayout(2840, 650, 110,90,-7,user1);
                floorBlock15 = new BlockLayout( 2990, 580,110, 90, -7, user1);
                floorBlock16 = new BlockLayout(3250, 490, 110,90, -7,user1);
                floorBlock17 = new BlockLayout(3510, 400, 110,90,-7, user1);
                oneSpike4 = new SpikeLayout(3589,366,40,40,-7,user1);
                floorBlock18 = new BlockLayout(3750, 310,110,90,-7,user1 );
                floorBlock19 = new BlockLayout(3890, 270,110,70,-7,user1);
                threeSpike7 = new SpikeLayout(3915,227, 75,45,-7,user1);
                floorBlock20 = new BlockLayout(4100,310,300, 90, -7,user1);
                oneSpike5 = new SpikeLayout(4250,277,40,40,-7,user1);
                floorBlock21 = new BlockLayout(4490,465,40,100, -7,user1);
                floorBlock22 = new BlockLayout(4490,535,40,100,-7,user1);
                LongFloorBlock3 = new BlockLayout(4700,475,690,90,-7,user1);
                meanSpike = new SpikeLayout( 4675,437,40,40,-7,user1);
                threeSpike8 = new SpikeLayout(4900, 434,75,45, -7, user1);
                oneSpike6 = new SpikeLayout(5350,437,40,40,-7,user1);
                floorBlock23 = new BlockLayout(5420, 305, 110,90, -7 ,user1);
                hiddenSpike = new SpikeLayout(5420,340,40,40,-7,user1);
                floorBlock24 = new BlockLayout(5650, 250,300,90,-7,user1);
                oneSpike7 = new SpikeLayout (5912, 217,40, 40,-7,user1);
                floorBlock25 = new BlockLayout( 5987,215, 110, 90, -7 ,user1 );
                threeSpike9 = new SpikeLayout(5985,192,75,45,-7,user1);
                oneSpike8 = new SpikeLayout( 6350, 710,40,40, -7 ,user1);
                threeSpike10 = new SpikeLayout( 6730, 705, 75,45, -7, user1);


                CityBlocksFORWallPaper4MIDDLEUP = new ArrayList<>();
                for (int i = 0; i < 12; i++) {
                        dogeCityBlocksMIDDLEUP = new BlockLayout((280 * i), -20, 300, 365, -6, user1);
                        CityBlocksFORWallPaper4MIDDLEUP.add(dogeCityBlocksMIDDLEUP);
                }
                CityBlocksFORWallPaper4MIDDLEDOWN = new ArrayList<>();
                for (int i = 0; i < 14; i++) {
                        dogeCityBlocksMIDDLEDOWN = new BlockLayout((150 * i) + 510, 545, 250, 490, -6, user1);
                        CityBlocksFORWallPaper4MIDDLEDOWN.add(dogeCityBlocksMIDDLEDOWN);
                }
                CityBlocksFORWallPaper4LOWUP = new ArrayList<>();
                for(int i = 0; i < 5; i ++){
                        dogeCityBlocksLOWUP = new BlockLayout((280 *i)+2700,-20,350,410,-6,user1);
                        CityBlocksFORWallPaper4LOWUP.add(dogeCityBlocksLOWUP);
                }
                CityBlocksFORWallPaper4LOWDOWN = new ArrayList<>();
                for ( int i = 0; i < 8; i ++){
                        dogeCityBlocksLOWDOWN = new BlockLayout((150*i)+2700,650 , 225,300,-6,user1);
                        CityBlocksFORWallPaper4LOWDOWN.add(dogeCityBlocksLOWDOWN);
                }
                CityBlocksFORWallPaper4HIGHUP = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                        dogeCityBlocksHIGHUP = new BlockLayout((280 * i) + 3950, -20, 350, 330, -6, user1);
                        CityBlocksFORWallPaper4HIGHUP.add(dogeCityBlocksHIGHUP);
                }
                CityBlocksFORWallPaper4HIGHDOWN = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                        dogeCityBlocksHIGHDOWN = new BlockLayout((150 * i) + 3950, 555, 140, 520, -6, user1);
                        CityBlocksFORWallPaper4HIGHDOWN.add(dogeCityBlocksHIGHDOWN);
                }

                portal1 = new PortalLayout(6825, 520,30,240,-7);
                portal2 = new PortalLayout(5410, 240, 80,410,-6 );

                groundX = 0;
                groundY = 749;
                timer = 0;

                StartScreen = loadImage("GameScreens/Doge actual screen.png");
                StartScreen.resize(width, height);
                GameOver = loadImage("GameScreens/endgame.png");
                GameOver.resize(width, height);
                FinishedGame = loadImage( "GameScreens/youfinished.png");
                FinishedGame.resize(width,height);

                portal = loadImage("GameItems/portal.png");
                portal.resize(portal1.portalW, portal1.portalH);
                downPortal = loadImage( "GameItems/portalDownward.png");
                downPortal.resize(portal2.portalW,portal2.portalH);

                UserIcon = loadImage("GameItems/DOGE.png");
                UserIcon.resize(user1.UserWidth, (int) user1.UserHeight);

                OneSpike = loadImage("GameItems/SPIKE.png");
                OneSpike.resize(spikeOne.SpikeWidth, spikeOne.SpikeHeight);
                threeSpikes = loadImage("GameItems/threeSpike.png");
                threeSpikes.resize(spikeThrees.SpikeWidth, spikeThrees.SpikeHeight);
                manySpikes = loadImage("GameItems/threeSpike.png");
                manySpikes.resize(soManySpikes.SpikeWidth,soManySpikes.SpikeHeight);

                dogeFloorBlock1 = loadImage("GameItems/Floors/dogefloor1.png");
                dogeFloorBlock1.resize(FloorBlock1.dogeBlockWidth, (int) FloorBlock1.dogeBlockHeight);
                dogeFloorBlock2 = loadImage( "GameItems/Floors/dogeFloor2.png");
                dogeFloorBlock2.resize(FloorBlock2.dogeBlockWidth,(int) FloorBlock2.dogeBlockHeight);
                dogeFloorBLock3 = loadImage( "GameItems/Floors/dogefloor3.png");
                dogeFloorBLock3.resize(FloorBlock3.dogeBlockWidth,(int) FloorBlock3.dogeBlockHeight);
                dogeFloorBlock4 = loadImage("GameItems/Floors/dogefloor4.png");
                dogeFloorBlock4.resize(FloorBlock4.dogeBlockWidth,(int) FloorBlock4.dogeBlockHeight);
                dogeFloorBlock5 = loadImage("GameItems/Floors/dogefloor5.png");
                dogeFloorBlock5.resize(FloorBlock5.dogeBlockWidth,(int) FloorBlock5.dogeBlockHeight);
                dogeFloorBlock6 = loadImage("GameItems/Floors/dogefloor6.png");
                dogeFloorBlock6.resize(FloorBlock6.dogeBlockWidth, (int) FloorBlock6.dogeBlockHeight);
                dogeFloorBlock7 = loadImage("GameItems/Floors/dogefloor7.png");
                dogeFloorBlock7.resize(FloorBlock7.dogeBlockWidth,(int) FloorBlock7.dogeBlockHeight);
                dogeFloor10 = loadImage("GameItems/Floors/dogefloor10.png");
                dogeFloor10.resize(floorBlock10.dogeBlockWidth, (int) floorBlock10.dogeBlockHeight);
                dogFloor20 = loadImage( "GameItems/Floors/dogefloor20.png");
                dogFloor20.resize(floorBlock20.dogeBlockWidth,(int) floorBlock20.dogeBlockHeight);

                dogeLongFloorBlock1 = loadImage( "GameItems/Floors/longdogefloor1.png");
                dogeLongFloorBlock1.resize(LongFloorBlock1.dogeBlockWidth, (int) LongFloorBlock1.dogeBlockHeight);
                dogeLongFloorBlock2 = loadImage( "GameItems/Floors/longdogefloor2.png");
                dogeLongFloorBlock2.resize(LongFloorBlock2.dogeBlockWidth,(int) LongFloorBlock2.dogeBlockHeight);

                dogBlockMiddleUp = loadImage("GameItems/Blocks/dogeBlock.png");
                dogBlockMiddleUp.resize(dogeCityBlocksMIDDLEUP.dogeBlockWidth, (int) dogeCityBlocksMIDDLEUP.dogeBlockHeight);
                dogBlockMiddleDown = loadImage("GameItems/Blocks/DOGEBLOCKDOWN2.png");
                dogBlockMiddleDown.resize(dogeCityBlocksMIDDLEDOWN.dogeBlockWidth, (int) dogeCityBlocksMIDDLEDOWN.dogeBlockHeight);
                dogBlockLowUp = loadImage("GameItems/Blocks/DogeBlock3.png");
                dogBlockLowUp.resize(dogeCityBlocksLOWUP.dogeBlockWidth, (int) dogeCityBlocksLOWUP.dogeBlockHeight);
                dogBlockLowDown = loadImage( "GameItems/Blocks/DogeBlock4.png");
                dogBlockLowDown.resize(dogeCityBlocksLOWDOWN.dogeBlockWidth, (int) dogeCityBlocksLOWDOWN.dogeBlockHeight);
                dogBlockHighUp = loadImage("GameItems/Blocks/DOGEBLOCK2.png");
                dogBlockHighUp.resize(dogeCityBlocksHIGHUP.dogeBlockWidth, (int) dogeCityBlocksHIGHUP.dogeBlockHeight);
                dogeBlockHighDown = loadImage("GameItems/Blocks/dogeblock6.png");
                dogeBlockHighDown.resize(dogeCityBlocksHIGHDOWN.dogeBlockWidth, (int) dogeCityBlocksHIGHDOWN.dogeBlockHeight);

                wallPaper1 = loadImage("Wallpapers/WallPaper1.png");
                wallPaper1.resize(width, height);
                wallPaper2 = loadImage("Wallpapers/WallPaper2.png");
                wallPaper2.resize(width, height);
                wallPaper3 = loadImage("Wallpapers/WallPaper3.png");
                wallPaper3.resize(width, height);
                wallPaper4 = loadImage("Wallpapers/WallPaper4.png");
                wallPaper4.resize(width, height);
                wallPaper5 = loadImage("Wallpapers/happyfamily.png");
                wallPaper5.resize(width,height);

                gifList = new PImage[]{loadImage("Wallpapers/EndingScreen/light1.gif"),loadImage("Wallpapers/EndingScreen/light2.gif"),loadImage("Wallpapers/EndingScreen/light3.gif"),
                        loadImage("Wallpapers/EndingScreen/light4.gif"), loadImage("Wallpapers/EndingScreen/light5.gif"), loadImage("Wallpapers/EndingScreen/light6.gif"),loadImage("Wallpapers/EndingScreen/light7.gif"),
                        loadImage("Wallpapers/EndingScreen/light8.gif"), loadImage("Wallpapers/EndingScreen/light9.gif"), loadImage("Wallpapers/EndingScreen/light10.gif"),loadImage("Wallpapers/EndingScreen/light11.gif"),
                        loadImage("Wallpapers/EndingScreen/light12.gif")};
                for ( PImage gif :gifList){
                        gif.resize(width,height);
                }

                loader = new Minim( this);
                oofNoise = loader.loadFile("oof soundeffect.wav");
                song = loader.loadFile("dogedashSONG.wav");

        }

        public void draw() {
                if (mode == STARTING) {
                        StartingPage();
                } else if (mode == NORMAL_GAMEPLAY) {
                        normalPlay();
                        song.play();
                } else if (mode == GAME_OVER) {
                        gameOver();
                } else if (mode == finishedGame) {
                        finished();
                }
        }

        public void StartingPage() {
                image(StartScreen, 0, 0);
                keyPressing();
        }

        public boolean isOnGround() {
                return user1.UserY + (user1.UserHeight + 15) >= groundY;
        }

        public void FlyingDoge() {
                if (groundCheckNOTApplied()) {
                        if (spaceBarIsPressed) {
                                jumpSettings();
                        } else {
                                GravitySettings();
                        }
                }
        }

        public boolean groundCheckNOTApplied() {
                if (!(isOnGround())) {
                        return true;
                }
                return false;
        }

        public void timerSetting() {
                timer++;
                if (timer % 60 == 0) {
                        second++;
                }
                if (second == 60) {
                        minute++;
                        second = 0;
                }

        }

        public void spikeSettings() {
                if (second < 15 && minute == 0) {
                        for (SpikeLayout spikeOne : oneSpikeListFORWallPaper1) {
                                image(OneSpike, spikeOne.SpikeX, spikeOne.SpikeY);
                                spikeOne.spikeActions();
                        }
                        for (SpikeLayout spikeThree : threesSpikeListFORWallPaper1) {
                                image(threeSpikes, spikeThree.SpikeX, spikeThree.SpikeY);
                                spikeThree.spikeActions();
                        }
                        if (spikeOne.SpikeX + spikeOne.SpikeWidth < 0) {
                                oneSpikeListFORWallPaper1.remove(spikeOne);
                        }
                        if (spikeThrees.SpikeX + spikeThrees.SpikeWidth < 0) {
                                threesSpikeListFORWallPaper1.remove(spikeThrees);
                        }
                }

                if (second >= 15 && second < 29 && minute == 0) {
                        for (SpikeLayout soManySpikes : threeSpikeFORWallPaper2) {
                                image(manySpikes, soManySpikes.SpikeX, soManySpikes.SpikeY);
                                soManySpikes.spikeActions();
                        }
                        image(OneSpike, spikey.SpikeX, spikey.SpikeY);
                        spikey.spikeActions();
                }

                if (second >= 29 && second < 45 && minute == 0) {
                        image(threeSpikes, threeSpike1.SpikeX, threeSpike1.SpikeY);
                        threeSpike1.spikeActions();
                        image(OneSpike, oneSpike1.SpikeX, oneSpike1.SpikeY);
                        oneSpike1.spikeActions();
                        image(OneSpike,insideSpike1.SpikeX,insideSpike1.SpikeY);
                        insideSpike1.spikeActions();
                        image(threeSpikes, threeSpike2.SpikeX, threeSpike2.SpikeY);
                        threeSpike2.spikeActions();
                        image(OneSpike, oneSpike2.SpikeX,oneSpike2.SpikeY);
                        oneSpike2.spikeActions();
                        image(OneSpike, insideSpike2.SpikeX,insideSpike2.SpikeY);
                        insideSpike2.spikeActions();
                        image(OneSpike, oneSpike3.SpikeX,oneSpike3.SpikeY);
                        oneSpike3.spikeActions();
                        image(threeSpikes, threeSpike3.SpikeX, threeSpike3.SpikeY);
                        threeSpike3.spikeActions();
                        image(threeSpikes, threeSpike4.SpikeX, threeSpike4.SpikeY);
                        threeSpike4.spikeActions();
                        image(threeSpikes, threeSpike5.SpikeX,threeSpike5.SpikeY);
                        threeSpike5.spikeActions();
                        image(threeSpikes,threeSpike6.SpikeX,threeSpike6.SpikeY);
                        threeSpike6.spikeActions();
                        for (SpikeLayout spiking : threeSpikeFORWallPaper3) {
                                image(threeSpikes, spiking.SpikeX, spiking.SpikeY);
                                spiking.spikeActions();
                        }
                        image(OneSpike, oneSpike4.SpikeX,oneSpike4.SpikeY);
                        oneSpike4.spikeActions();
                        image(threeSpikes, threeSpike7.SpikeX,threeSpike7.SpikeY);
                        threeSpike7.spikeActions();
                        image(OneSpike,oneSpike5.SpikeX,oneSpike5.SpikeY);
                        oneSpike5.spikeActions();
                        image(OneSpike, meanSpike.SpikeX,meanSpike.SpikeY);
                        meanSpike.spikeActions();
                        image(threeSpikes, threeSpike8.SpikeX, threeSpike8.SpikeY);
                        threeSpike8.spikeActions();
                        image(OneSpike, oneSpike6.SpikeX, oneSpike6.SpikeY);
                        oneSpike6.spikeActions();
                        image(OneSpike, oneSpike7.SpikeX,oneSpike7.SpikeY);
                        oneSpike7.spikeActions();
                        image(threeSpikes, threeSpike9.SpikeX,threeSpike9.SpikeY);
                        threeSpike9.spikeActions();
                        image(OneSpike,hiddenSpike.SpikeX,hiddenSpike.SpikeY);
                        hiddenSpike.spikeActions();
                        image(OneSpike, oneSpike8.SpikeX, oneSpike8.SpikeY);
                        oneSpike8.spikeActions();
                        image(threeSpikes, threeSpike10.SpikeX,threeSpike10.SpikeY);
                        threeSpike10.spikeActions();
                }
        }

        public void blockSettings() {
                if (second >= 15 && second < 29 && minute == 0) {
                        for( BlockLayout FloorBlock1: FloorBlocksFORWallPaper2) {
                                image(dogeFloorBlock1, FloorBlock1.dogeBlockX, FloorBlock1.dogeBlockY);
                                FloorBlock1.floorBlockActions();
                        }
                        image(dogeFloorBlock2, FloorBlock2.dogeBlockX, FloorBlock2.dogeBlockY);
                        FloorBlock2.floorBlockActions();
                        image(dogeFloorBLock3, FloorBlock3.dogeBlockX, FloorBlock3.dogeBlockY);
                        FloorBlock3.floorBlockActions();
                        image(dogeFloorBlock4, FloorBlock4.dogeBlockX, FloorBlock4.dogeBlockY);
                        FloorBlock4.floorBlockActions();
                        image(dogeFloorBlock5, FloorBlock5.dogeBlockX, FloorBlock5.dogeBlockY);
                        FloorBlock5.floorBlockActions();
                        image(dogeFloorBlock6, FloorBlock6.dogeBlockX, FloorBlock6.dogeBlockY);
                        FloorBlock6.floorBlockActions();
                        image(dogeFloorBlock7, FloorBlock7.dogeBlockX, FloorBlock7.dogeBlockY);
                        FloorBlock7.floorBlockActions();
                        image(dogeFloorBlock1, FloorBlock8.dogeBlockX,FloorBlock8.dogeBlockY);
                        FloorBlock8.floorBlockActions();
                        image(dogeFloorBLock3, FloorBlock9.dogeBlockX,FloorBlock9.dogeBlockY);
                        FloorBlock9.floorBlockActions();

                        image(dogeLongFloorBlock1, LongFloorBlock1.dogeBlockX, LongFloorBlock1.dogeBlockY);
                        LongFloorBlock1.floorBlockActions();
                        image(dogeLongFloorBlock2, LongFloorBlock2.dogeBlockX, LongFloorBlock2.dogeBlockY);
                        LongFloorBlock2.floorBlockActions();
                }

                if(second >= 29 && second < 45 && minute == 0) {
                        image(dogeFloor10, floorBlock10.dogeBlockX, floorBlock10.dogeBlockY);
                        floorBlock10.floorBlockActions();
                        image(dogeFloor10, floorBlock11.dogeBlockX,floorBlock11.dogeBlockY);
                        floorBlock11.floorBlockActions();
                        image(dogeFloorBlock6, floorBlock12.dogeBlockX,floorBlock12.dogeBlockY);
                        floorBlock12.floorBlockActions();
                        image(dogeFloor10, floorBlock13.dogeBlockX,floorBlock13.dogeBlockY);
                        floorBlock13.floorBlockActions();
                        image(dogeFloorBlock6, floorBlock14.dogeBlockX,floorBlock14.dogeBlockY);
                        floorBlock14.floorBlockActions();
                        image(dogeFloorBlock6, floorBlock15.dogeBlockX,floorBlock15.dogeBlockY);
                        floorBlock15.floorBlockActions();
                        image(dogeFloorBlock6 , floorBlock16.dogeBlockX,floorBlock16.dogeBlockY);
                        floorBlock16.floorBlockActions();
                        image(dogeFloorBlock6, floorBlock17.dogeBlockX,floorBlock17.dogeBlockY);
                        floorBlock17.floorBlockActions();
                        image(dogeFloorBlock6, floorBlock18.dogeBlockX, floorBlock18.dogeBlockY);
                        floorBlock18.floorBlockActions();
                        image(dogeFloorBlock6,floorBlock19.dogeBlockX,floorBlock19.dogeBlockY);
                        floorBlock19.floorBlockActions();
                        image(dogFloor20 , floorBlock20.dogeBlockX, floorBlock20.dogeBlockY);
                        floorBlock20.floorBlockActions();
                        image(dogeFloor10, floorBlock21.dogeBlockX,floorBlock21.dogeBlockY);
                        floorBlock21.floorBlockActions();
                        image(dogeFloor10, floorBlock22.dogeBlockX,floorBlock22.dogeBlockY);
                        floorBlock22.floorBlockActions();
                        image(dogeLongFloorBlock2, LongFloorBlock3.dogeBlockX, LongFloorBlock3.dogeBlockY);
                        LongFloorBlock3.floorBlockActions();
                        image( dogeFloorBlock6, floorBlock23.dogeBlockX,floorBlock23.dogeBlockY);
                        floorBlock23.floorBlockActions();
                        image( dogFloor20, floorBlock24.dogeBlockX,floorBlock24.dogeBlockY);
                        floorBlock24.floorBlockActions();
                        image(dogeFloorBlock6, floorBlock25.dogeBlockX,floorBlock25.dogeBlockY);
                        floorBlock25.floorBlockActions();

                        image(portal, portal1.portalX,portal1.portalY);
                        portal1.portalMovement();
                }

                if (second >= 45 && second <= 60 && minute == 0) {
                        for (BlockLayout dogeCityBlocksMIDDLEUp : CityBlocksFORWallPaper4MIDDLEUP) {
                                image(dogBlockMiddleUp, dogeCityBlocksMIDDLEUp.dogeBlockX, dogeCityBlocksMIDDLEUp.dogeBlockY);
                                dogeCityBlocksMIDDLEUp.cityBlockActions();
                        }
                        for (BlockLayout dogeCityBlockMIDDLEDown : CityBlocksFORWallPaper4MIDDLEDOWN) {
                                image(dogBlockMiddleDown, dogeCityBlockMIDDLEDown.dogeBlockX, dogeCityBlockMIDDLEDown.dogeBlockY);
                                dogeCityBlockMIDDLEDown.cityBlockActions();
                        }
                        for ( BlockLayout dogeCityBlocksLOWUP: CityBlocksFORWallPaper4LOWUP){
                                image(dogBlockLowUp, dogeCityBlocksLOWUP.dogeBlockX,dogeCityBlocksLOWUP.dogeBlockY);
                                dogeCityBlocksLOWUP.cityBlockActions();
                        }
                        for(BlockLayout dogeCityBlocksLOWDOWN: CityBlocksFORWallPaper4LOWDOWN){
                                image(dogBlockLowDown,dogeCityBlocksLOWDOWN.dogeBlockX,dogeCityBlocksLOWDOWN.dogeBlockY);
                                dogeCityBlocksLOWDOWN.cityBlockActions();
                        }

                        for (BlockLayout dogeCityBlocksHIGHUP : CityBlocksFORWallPaper4HIGHUP) {
                                image(dogBlockHighUp, dogeCityBlocksHIGHUP.dogeBlockX, dogeCityBlocksHIGHUP.dogeBlockY);
                                dogeCityBlocksHIGHUP.cityBlockActions();
                        }
                        for (BlockLayout dogeCityBlocksHIGHDOWN : CityBlocksFORWallPaper4HIGHDOWN) {
                                image(dogeBlockHighDown, dogeCityBlocksHIGHDOWN.dogeBlockX, dogeCityBlocksHIGHDOWN.dogeBlockY);
                                dogeCityBlocksHIGHDOWN.cityBlockActions();
                        }
                        image(downPortal, portal2.portalX, portal2.portalY);
                        portal2.portalMovement();
                }
        }

        public void GameLooks() {
                fill(226, 52, 235);
                textSize(30);
                text("Lives :" + user1.lives, 930, 100);
                fill(226, 52, 235);
                textSize(32);
                text("Timer=" + minute + ":" + second, 930, 45);

                image(UserIcon, user1.UserX, user1.UserY);

                if(second < 60 && minute == 0) {
                        fill(color(255, 0, 0));
                        stroke(255, 0, 0);
                        strokeWeight(15);
                        line(0, 748, width, 748);
                }
        }

        public void wallPapers() {
                if (second < 15 && minute == 0) {
                        image(wallPaper1, 0, 0);
                        GameLooks();
                } else if (second >= 15 && second < 29 && minute == 0) {
                        image(wallPaper2, 0, 0);
                        GameLooks();
                } else if (second >= 29 && second < 45 && minute == 0) {
                        image(wallPaper3, 0, 0);
                        GameLooks();
                } else if (second >= 45 && second <= 60 && minute == 0 ) {
                        image(wallPaper4, 0, 0);
                        GameLooks();
                } else if (minute > 0 && second < 13 ) {
                        image(gifList[frameCount % 12], 0, 0);
                        GameLooks();
                        user1.gravity = (float) 0;
                        user1.UserX = 564;
                        user1.UserY = 370;
                } else if( second >= 13 && second < 15 && minute > 0 ){
                        image(wallPaper5,0,0);
                } else if (second >= 17 &&  minute >0) {
                        finished();
                }
        }

        public void GravitySettings() {
                user1.UserY = user1.UserY + user1.UserSpeedY;
                user1.UserSpeedY = user1.UserSpeedY + user1.gravity;
                if (second < 45 && minute == 0) {
                        user1.jumpPower = -18;
                        user1.gravity = (float) 1;
                } else if (second >= 45 && second <= 60 && minute == 0) {
                        user1.gravity = (float) 0.5;
                        user1.jumpPower = (float) -4;
                }

        }

        public void jumpSettings() {
                GravitySettings();
                user1.UserSpeedY = user1.jumpPower;
        }

        public boolean floorBlockGroundCheck(){
                if(FloorBlocksFORWallPaper2.get(0).blockGroundCheck() || FloorBlocksFORWallPaper2.get(1).blockGroundCheck() ||FloorBlocksFORWallPaper2.get(2).blockGroundCheck() ||
                        FloorBlock2.blockGroundCheck() || FloorBlock3.blockGroundCheck() || FloorBlock4.blockGroundCheck()|| FloorBlock5.blockGroundCheck()|| FloorBlock6.blockGroundCheck()|| FloorBlock7.blockGroundCheck()|| FloorBlock8.blockGroundCheck()|| FloorBlock9.blockGroundCheck()||
                        floorBlock10.blockGroundCheck()||floorBlock11.blockGroundCheck()|| floorBlock12.blockGroundCheck()||floorBlock13.blockGroundCheck()|| floorBlock14.blockGroundCheck()||floorBlock15.blockGroundCheck()||floorBlock16.blockGroundCheck()||floorBlock17.blockGroundCheck()||
                        floorBlock18.blockGroundCheck()|| floorBlock20.blockGroundCheck()||floorBlock22.blockGroundCheck()||floorBlock23.blockGroundCheck()|| floorBlock24.blockGroundCheck()||
                        LongFloorBlock1.blockGroundCheck()|| LongFloorBlock2.blockGroundCheck()||LongFloorBlock3.blockGroundCheck()){
                        return true;
                }
                return false;
        }

        public void normalPlay() {
                wallPapers();
                spikeSettings();
                blockSettings();
                timerSetting();
                keyPressing();
                lostLife();

                if (isOnGround() ||floorBlockGroundCheck()) {
                        if (spaceBarIsPressed) {
                                jumpSettings();
                        }
                } else  {
                        GravitySettings();
                }
        }

        public void lostLife(){
                if (user1.lives <= 0) {
                        mode = GAME_OVER;
                        spaceBarIsPressed = false;
                        second = 0;
                        minute = 0;
                        oofNoise.play();
                        song.pause();
                }
        }

        public void keyPressing () {
                if (keyPressed) {
                        if (mode == STARTING) {
                                if (key == ' ') {
                                        mode = NORMAL_GAMEPLAY;
                                }
                        } else if (mode == NORMAL_GAMEPLAY) {
                                if (second < 45) {
                                        if (key == ' ' && isOnGround() || floorBlockGroundCheck()) {
                                                jumpSettings();
                                        }
                                }
                                if (second >= 45 && second <= 60 && minute == 0) {
                                        if (key == ' ') {
                                                FlyingDoge();
                                                jumpSettings();
                                                lostLife();
                                        }
                                }
                        } else if (mode == GAME_OVER) {
                                if (key == 'r') {
                                        mode = NORMAL_GAMEPLAY;
                                        setup();
                                }
                        } else if (mode == finishedGame) {
                                if (key == 'r') {
                                        mode = NORMAL_GAMEPLAY;
                                        setup();
                                }
                        }
                }
        }

        public void gameOver () {
                keyPressing();
                image(GameOver, 0, 0);
                song.pause();

        }

        public void finished (){
                keyPressing();
                image(FinishedGame, 0, 0);
                song.pause();

        }

        public static void main (String[]args){
                PApplet.main("GamePlay");
        }
}



