/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pengg8152
 */
public interface Collidable
{
    public boolean didCollideLeft(Block b);
    public boolean didCollideRight(Block b);
    public boolean didCollideTop(Block b);
    public boolean didCollideBottom(Block b);
}
