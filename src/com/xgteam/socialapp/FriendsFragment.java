package com.xgteam.socialapp;

import com.xgteam.utils.*;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class FriendsFragment extends Fragment implements OnTabChangeListener,
		TabListener {

	public FriendsFragment() {

	}

	private TabHost _tabHost;
	private View _viewRoot;

	private final TabDefinition[] TAB_DEFINITIONS = new TabDefinition[] {
			new FriendsTab(R.id.tab1, R.layout.simple_tab,
					R.string.tab_title_1, R.id.tabTitle,
					new FriendsListFragment()),
			new FriendsTab(R.id.tab2, R.layout.simple_tab,
					R.string.tab_title_2, R.id.tabTitle,
					new FriendsListFragment().setOnlineMode()) };
	private FriendsListFragment allFriends = new FriendsListFragment();
	private FriendsListFragment onlineFriends = new FriendsListFragment();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		 _viewRoot = (View) inflater.inflate(R.layout.fragment_friends, null);
		
		 _tabHost = (TabHost)_viewRoot.findViewById(android.R.id.tabhost);
		 _tabHost.setup();
		
		 for (TabDefinition tab : TAB_DEFINITIONS) {
		 _tabHost.addTab(createTab(inflater, _tabHost, _viewRoot, tab));
		 }
		 _tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.tab_item);
		 _tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.tab_item);
		return _viewRoot;
	}

	private TabSpec createTab(LayoutInflater inflater, TabHost tabHost,
			View root, TabDefinition tabDefinition) {
		ViewGroup tabsView = (ViewGroup) root.findViewById(android.R.id.tabs);
		View tabView = tabDefinition.createTabView(inflater, tabsView);

		TabSpec tabSpec = tabHost.newTabSpec(tabDefinition.getId());
		tabSpec.setIndicator(tabView);
		tabSpec.setContent(tabDefinition.getTabContentViewId());
		return tabSpec;
	}

	private void updateTab(String tabId, Fragment fragment, int containerId) {
		final FragmentManager manager = getFragmentManager();
		if (manager.findFragmentByTag(tabId) == null) {
			manager.beginTransaction().replace(containerId, fragment, tabId)
					.commit();
		}
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		for (TabDefinition tab : TAB_DEFINITIONS) {
			if (tabId != tab.getId()) {
				continue;
			}

			updateTab(tabId, tab.getFragment(), tab.getTabContentViewId());
			return;
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);
		//getActivity().getActionBar().setNavigationMode(
//				ActionBar.NAVIGATION_MODE_TABS);
//		ActionBar.Tab tab1 = getActivity().getActionBar().newTab()
//				.setText("Всі друзі");
//		tab1.setTabListener(this);
//		ActionBar.Tab tab2 = getActivity().getActionBar().newTab()
//				.setText("Всі друзі");
//		tab2.setTabListener(this);
//		getActivity().getActionBar().addTab(tab1);
//		getActivity().getActionBar().addTab(tab2);
		_tabHost.setOnTabChangedListener(this);

		if (TAB_DEFINITIONS.length > 0) {
			onTabChanged(TAB_DEFINITIONS[0].getId());
		}
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		switch (tab.getPosition()) {
		case 0: {
			ft.add(android.R.id.content, allFriends);
		}
			break;
		case 1: {
			ft.add(android.R.id.content, onlineFriends);
		}
			break;
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		switch (tab.getPosition()) {
		case 0: {
			ft.detach(allFriends);
		}
			break;
		case 1: {
			ft.detach(onlineFriends);
		}
			break;
		}
	}
}
