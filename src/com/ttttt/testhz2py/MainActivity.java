package com.ttttt.testhz2py;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.ttttt.utils.HanziToPinyin;
import com.ttttt.utils.HanziToPinyin.Token;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<Token> tokens = HanziToPinyin.getInstance().get("‡å");
		StringBuilder sb = new StringBuilder();
		if (tokens != null && tokens.size() > 0) {
			for (Token token : tokens) {
				if (Token.PINYIN == token.type) {
					sb.append(token.target);
				} else {
					sb.append(token.source);
				}
			}
		}
		String py = sb.toString().toLowerCase(Locale.CHINA);
		Log.w("HanziToPinyin", py);
	}

}
