package edu.cnm.deepdive.dogsapp.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.dogsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

  @BindView(R.id.floatingActionButton3)
  FloatingActionButton fab3;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_detail, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    fab3.setOnClickListener(v -> onGoToList());
  }

  private void onGoToList() {
    NavDirections action = DetailFragmentDirections.actionList();
    Navigation.findNavController(fab3).navigate(action);
  }
}
