package edu.cnm.deepdive.dogsapp.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.dogsapp.R;

public class ListFragment extends Fragment {

  @BindView(R.id.floatingActionButton)
  FloatingActionButton fab;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_list, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    fab.setOnClickListener(v -> onGoToDetails());
  }

   void onGoToDetails() {
    NavDirections action = ListFragmentDirections.actionDetail();
    Navigation.findNavController(fab).navigate(action);
  }
}
