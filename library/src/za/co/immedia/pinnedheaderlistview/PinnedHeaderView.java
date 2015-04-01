package za.co.immedia.pinnedheaderlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class PinnedHeaderView extends RelativeLayout {

	public PinnedHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public PinnedHeaderView(Context context, AttributeSet attrs) {
		this(context, attrs, -1);
	}

	public PinnedHeaderView(Context context) {
		this(context, null);
	}
}
