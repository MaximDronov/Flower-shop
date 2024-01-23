package com.example.listsandadapters;

public class State {

    private String name;
    private String sort;
    private int flower;
    private int quantity;
    private boolean isSelected;

    public State(String name, String sort, int flower){

        this.name=name;
        this.sort=sort;
        this.flower=flower;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getFlagResource() {
        return this.flower;
    }

    public void setFlower(int flower) {
        this.flower = flower;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
