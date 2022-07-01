/**
 * NAMA : FAKHRI ADI SAPUTRA
 * NIM : 10119116
 * KELAS : IF-3
 */
package id.fakhrads.foodish10119116.ui.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import id.fakhrads.foodish10119116.databinding.FragmentHomeBinding;

import id.fakhrads.foodish10119116.R;

public class HomeFragment extends Fragment implements OnMapReadyCallback{
    private static final String MY_LOCATION_REQUEST_CODE= "LOCATION_PERMISSIONS";

    private FragmentHomeBinding binding;
    private View fragmentView;
    private GoogleMap mMap;
    private FusedLocationProviderClient client;


    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return root;
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.

        LatLng warkop99 = new LatLng(-6.886516, 107.616329);
        googleMap.addMarker(new MarkerOptions().position(warkop99)
                .title("Warkop 99"));


        LatLng warkopJagoRasa = new LatLng(-6.888712, 107.619159);
        googleMap.addMarker(new MarkerOptions().position(warkopJagoRasa)
                .title("Warkop Jago Rasa"));


        LatLng yezChicken = new LatLng(-6.889233, 107.617374);
        googleMap.addMarker(new MarkerOptions().position(yezChicken)
                .title("Yez Chicken"));


        LatLng kantinaa = new LatLng(-6.889468, 107.617539);
        googleMap.addMarker(new MarkerOptions().position(kantinaa)
                .title("Kantin AA"));


        LatLng butatang = new LatLng(-6.889041, 107.621020);
        googleMap.addMarker(new MarkerOptions().position(butatang)
                .title("Kantin Bu Tatang"));

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if(isPermissionGranted()) {
            client = LocationServices.getFusedLocationProviderClient(getActivity());Task<Location> task = client.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null){
                        LatLng lokasi = new LatLng(location.getLatitude(),location.getLongitude());
                        MarkerOptions options = new MarkerOptions().position(lokasi).title("Lokasi Saat Ini");
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,17));
                        googleMap.addMarker(options);
                    } else {
                        Toast.makeText(getActivity(),"Tidak dapat membaca lokasi!",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(),"Akses lokasi dimatikan!",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isPermissionGranted() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION
                }, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }

    }


}