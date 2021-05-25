package kg.geektech.guesswords.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {


    protected void showToast(String message) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show();
    }

}
