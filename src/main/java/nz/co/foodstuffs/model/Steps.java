package nz.co.foodstuffs.model;

import java.util.List;

public class Steps {

    public List<Step> getstep() {
        return this.step;
    }

    public void setstep(List<Step> step) {
        this.step = step;
    }

    List<Step> step;
}