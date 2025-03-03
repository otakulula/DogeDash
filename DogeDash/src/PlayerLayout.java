public class PlayerLayout {
    int UserX, UserWidth, lives;
    float UserY, UserHeight, UserSpeedY, gravity, jumpPower;

    public PlayerLayout(int UserX, float UserY, int userW, float userH, float userSpeedY, int lives) {
        this.UserX = UserX;
        this.UserY = UserY;
        this.UserWidth = userW;
        this.UserHeight = userH;
        this.UserSpeedY = userSpeedY;
        this.lives = lives;
    }
}
