package com.example.responsi1mobileh1d023097.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobileh1d023097.data.model.Player
import com.example.responsi1mobileh1d023097.databinding.DialogPlayerDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: DialogPlayerDetailsBinding? = null
    private val binding get() = _binding!!

    // Kunci untuk mengambil data pemain
    companion object {
        const val TAG = "PlayerDetailsBottomSheet"
        private const val ARG_PLAYER = "player_data"

        fun newInstance(player: Player): PlayerDetailsBottomSheet {
            val fragment = PlayerDetailsBottomSheet()
            val args = Bundle()
            args.putSerializable(ARG_PLAYER, player) // Player harus mengimplementasikan Serializable
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogPlayerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengambil data pemain
        val player = arguments?.getSerializable(ARG_PLAYER) as? Player

        player?.let {
            // Mengisi data ke UI
            binding.dialogTvName.text = it.name
            binding.dialogTvBirthdate.text = it.dateOfBirth
            binding.dialogTvNationality.text = it.nationality
            binding.dialogTvPosition.text = it.position
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}