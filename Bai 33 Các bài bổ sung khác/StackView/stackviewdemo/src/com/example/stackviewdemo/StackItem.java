package com.example.stackviewdemo;

import android.graphics.drawable.Drawable;

public class StackItem {
	public String itemText;
	public Drawable itemPhoto;

	public StackItem(String text, Drawable photo) {
		this.itemPhoto = photo;
		this.itemText = text;
	}
}
