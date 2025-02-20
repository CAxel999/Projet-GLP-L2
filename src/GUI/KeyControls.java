package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControls implements KeyListener {
    private boolean upPressed, leftPressed, rightPressed, downPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        char keyChar = event.getKeyChar();
        switch (keyChar) {
            case 'q':
                leftPressed = true;
                break;
            case 'd':
                rightPressed = true;
                break;
            case 'z' :
                upPressed = true;
                break;
            case 's':
                downPressed = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        char keyChar = event.getKeyChar();
        switch (keyChar) {
            case 'q':
                leftPressed = false;
                break;
            case 'd':
                rightPressed = false;
                break;
            case 'z' :
                upPressed = false;
                break;
            case 's':
                downPressed = false;
                break;
            default:
                break;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
}

