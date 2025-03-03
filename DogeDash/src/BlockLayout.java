public class BlockLayout {
    int dogeBlockX, dogeBlockY,dogeBlockWidth, dogeBlockSpeed;
    double dogeBlockHeight;
    PlayerLayout user1;

    public BlockLayout(int DogeBlockX, int DogeBlockY, int DogeBlockW, int DogeBlockH, int dogeBlockSpeed, PlayerLayout user1) {
        this.dogeBlockX= DogeBlockX;
        this.dogeBlockY= DogeBlockY;
        this.dogeBlockWidth= DogeBlockW;
        this.dogeBlockHeight= DogeBlockH;
        this.dogeBlockSpeed= dogeBlockSpeed;
        this.user1 = user1;
    }

    public boolean blockGroundCheck(){
        if (user1.UserX + user1.UserWidth >= dogeBlockX && user1.UserX <= dogeBlockX + dogeBlockWidth && user1.UserY + user1.UserHeight >= dogeBlockY) {
            return true;
        }
        return false;
    }

    public boolean cityBlocksBoundary() {
        if(user1.UserX + user1.UserWidth >= dogeBlockX && user1.UserX <= dogeBlockX + dogeBlockWidth){
            if(user1.UserY + user1.UserHeight >= dogeBlockY && user1.UserY <= dogeBlockY + dogeBlockHeight){
                return true;
            }
        }
        return false;
    }

    public boolean floorBlockBoundary(){
        if(user1.UserX + user1.UserWidth >= dogeBlockX && user1.UserX <= dogeBlockX + dogeBlockWidth){
            if(user1.UserY + user1.UserHeight >= dogeBlockY && user1.UserY <= dogeBlockY + dogeBlockHeight/2){
                return true;
            }
        }
        return false;
    }

    public void blockCollision(){
        if(cityBlocksBoundary()){
            whenUserTouchesObstacle();
        }
        if(floorBlockBoundary()){
            whenUserTouchesObstacle();
        }
    }

    public void whenUserTouchesObstacle() {
        user1.lives--;
    }

    public void move(){
        dogeBlockX = dogeBlockX+ dogeBlockSpeed;
    }

    public void cityBlockActions(){
        blockCollision();
        move();
    }

    public void floorBlockActions(){
        move();
    }
}
