package za.co.immedia.pinnedheaderlistviewexample;

import za.co.immedia.pinnedheaderlistview.SectionedBaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TestSectionedAdapter extends SectionedBaseAdapter {

    @Override
    public Object getItem(int section, int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getSectionCount() {
        return 7;
    }

    @Override
    public int getCountForSection(int section) {
        return 15;
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.list_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        ((TextView) layout.findViewById(R.id.textItem)).setText("Section " + section + " Item " + position);
        return layout;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
    	
		View rowView = convertView;
		ViewHolder viewHolder = null;
		if (rowView == null) {
			rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, null);
			viewHolder = new ViewHolder();
			viewHolder.titleView = (TextView) rowView.findViewById(R.id.textItem);
			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) rowView.getTag();
		}

		String title = "Section header" + section;
		viewHolder.titleView.setText(title);
		viewHolder.titleView.setTag(title);
		rowView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Toast.makeText(v.getContext(), "PinnerHeaderView click", Toast.LENGTH_SHORT).show();
				}
				
				return true;
			}
		});
		
		viewHolder.titleView.setOnTouchListener(mTouchListener);

		return rowView;
    }
   
    private OnTouchListener mTouchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			
			int height = v.getMeasuredHeight();
			int width = v.getMeasuredWidth();
			
			if (event.getAction() == MotionEvent.ACTION_UP) {
				if (event.getX() > 0 && event.getX() < width && event.getY() > 0 && event.getY() < height) {
					Toast.makeText(v.getContext(), (String)v.getTag(), Toast.LENGTH_SHORT).show();
				}
			}
			
			return true;
		}
    };
    
    static class ViewHolder {
    	TextView titleView;
    }

}
