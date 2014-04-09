package com.xgteam.interfaces;

import java.util.List;

import com.xgteam.data.WallObject;

public interface WallWorker {
	List<WallObject> get(String type, int tid, String accessToken);
	void write(String type, int tid, String message, String accessToken);
}