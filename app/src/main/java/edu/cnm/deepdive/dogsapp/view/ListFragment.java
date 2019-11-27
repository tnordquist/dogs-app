package edu.cnm.deepdive.dogsapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import edu.cnm.deepdive.dogsapp.R;
import edu.cnm.deepdive.dogsapp.model.DogBreed;
import edu.cnm.deepdive.dogsapp.viewmodel.ListViewModel;
import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

  private ListViewModel viewModel;
  private DogsListAdapter dogsListAdapter = new DogsListAdapter(new ArrayList<>());

  @BindView(R.id.dogsList)
  RecyclerView dogsList;

  @BindView(R.id.listError)
  TextView listError;

  @BindView(R.id.loadingProgress)
  ProgressBar loadingProgress;

  @BindView(R.id.refreshLayout)
  SwipeRefreshLayout refreshLayout;

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

    ListFragmentDirections.ActionDetail action = ListFragmentDirections.actionDetail();
    Navigation.findNavController(view).navigate(action);


    viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
    viewModel.refresh();

    dogsList.setLayoutManager(new LinearLayoutManager(getContext()));
    dogsList.setAdapter(dogsListAdapter);
    observeViewModel();
  }

  private void observeViewModel() {
    viewModel.dogs.observe(this, dogs -> {
      if(dogs != null && dogs instanceof List){
        dogsList.setVisibility(View.VISIBLE);
        dogsListAdapter.updateDogsList(dogs);
      }
});

    viewModel.dogLoadError.observe(this, isError -> {

      if(isError != null && isError instanceof Boolean){
        listError.setVisibility(isError ? View.VISIBLE : View.GONE);
      }

    });

    viewModel.dogLoadError.observe(this, isLoading -> {

      if(isLoading != null && isLoading instanceof Boolean){
        loadingProgress.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        if(isLoading){
          listError.setVisibility(View.GONE);
          dogsList.setVisibility(View.GONE);
        }
      }

    });
  }

}
