    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView
    import com.bumptech.glide.Glide
    import com.example.bebo.R
    import com.example.bebo.lazyBone.Exercise

    class ExerciseAdapter : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

        private var exercises: List<Exercise> = listOf()

        fun submitList(newList: List<Exercise>) {
            exercises = newList
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
            return ExerciseViewHolder(view)
        }

        override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
            val exercise = exercises[position]
            holder.bind(exercise)
        }

        override fun getItemCount() = exercises.size

        class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val name: TextView = view.findViewById(R.id.exerciseName)
            private val image: ImageView = view.findViewById(R.id.exerciseImage)

            fun bind(exercise: Exercise) {
                name.text = exercise.name
                Glide.with(itemView.context).load(exercise.gifUrl).into(image)
            }
        }
    }
