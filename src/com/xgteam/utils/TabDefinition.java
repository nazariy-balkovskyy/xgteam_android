package com.xgteam.utils;

import java.util.UUID;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public abstract class TabDefinition {
	 private final int _tabContentViewId;
	 private final String _tabUuid;
	 
	 public TabDefinition(int tabContentViewId) {
	   _tabContentViewId = tabContentViewId;
	   _tabUuid = UUID.randomUUID().toString();
	 }
	 
	 public int getTabContentViewId() {
	   return _tabContentViewId;
	 }
	 
	 public String getId() {
	   return _tabUuid;
	 }
	 public abstract Fragment getFragment();
	 public abstract View createTabView(LayoutInflater inflater, ViewGroup tabsView);
}