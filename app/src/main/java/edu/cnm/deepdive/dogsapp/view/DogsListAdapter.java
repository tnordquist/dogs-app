package edu.cnm.deepdive.dogsapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.dogsapp.R;
import edu.cnm.deepdive.dogsapp.model.DogBreed;
import java.util.ArrayList;
import java.util.List;

public class DogsListAdapter extends RecyclerView.Adapter<DogsListAdapter.DogViewHolder> {

  private ArrayList<DogBreed> dogsList;

  public DogsListAdapter(ArrayList<DogBreed> dogsList) {
    this.dogsList = dogsList;
  }

  public void updateDogsList(List<DogBreed> newDogsList) {
    dogsList.clear();
    dogsList.addAll(newDogsList);
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false);
    return new DogViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull DogsListAdapter.DogViewHolder holder, int position) {

    ImageView image = holder.itemView.findViewById(R.id.imageView);
    TextView dogBreed = holder.itemView.findViewById(R.id.dogBreed);
    TextView bredFor = holder.itemView.findViewById(R.id.bredFor);

    dogBreed.setText(dogsList.get(position).dogBreed);
    bredFor.setText(dogsList.get(position).bredFor);

  }

  @Override
  public int getItemCount() {
    return dogsList.size();
  }

  public class DogViewHolder extends RecyclerView.ViewHolder {

    public View itemView;

    public DogViewHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
    }
  }
}
