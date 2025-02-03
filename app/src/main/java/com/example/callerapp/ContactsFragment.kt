import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.callerapp.Contact
import com.example.callerapp.PhoneNumberAdapter
import com.example.callerapp.R
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class ContactsFragment : Fragment() {

    private val contactList = listOf(
        Contact("Krishna", "8464032049"),
        Contact("Dileep", "7286087816"),
        Contact("Bhavana", "3333333333"),
        Contact("Mahesh", "3333333333"),
        Contact("Tulasi", "9999999999"),
        Contact("Madhu", "3333333333"),
        Contact("Bhanu", "3333333333"),
        Contact("NagaGanesh", "3333333333")

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewContacts)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PhoneNumberAdapter(contactList)
        return view
    }
}