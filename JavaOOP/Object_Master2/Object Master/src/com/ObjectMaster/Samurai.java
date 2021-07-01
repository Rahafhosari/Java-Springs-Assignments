package com.ObjectMaster;
import com.ObjectMaster.Wizard.*;

public class Samurai extends Human{
        private int count = 0;
        //Option 2
        //private static int count_static = 0;

        public Samurai(){
            this.setHealth(200);
            this.count += 1; //each time I am creating a samurai the counter is added
            //count_static ++;
        }

        public void deathBlow(Human R){
            R.setStealth(0);
            this.setStealth(this.getHealth()/2);
        }
        public void meditate(){
            this.setStealth(this.getStealth()+this.getHealth()/2);
        }
        public int howMany(){
            return this.count;
        }
        //if it was private static
//        public static int howMany_statics(){
//            return count_static;
//        }
}

