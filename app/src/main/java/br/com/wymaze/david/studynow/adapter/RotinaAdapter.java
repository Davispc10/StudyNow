package br.com.wymaze.david.studynow.adapter;

import android.content.Context;
import android.icu.text.StringPrepParseException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.wymaze.david.studynow.R;
import br.com.wymaze.david.studynow.model.Rotina;

/**
 * Created by davispc10 on 25/03/17.
 */

public class RotinaAdapter extends ArrayAdapter<Rotina> {
    private Context context = null;
    private ArrayList<Rotina> rotinas = null;

    public RotinaAdapter(Context context, ArrayList<Rotina> rotinas) {
        super(context, R.layout.linharotina, rotinas);
        this.context = context;
        this.rotinas = rotinas;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linharotina, parent, false);

        TextView hora = (TextView) rowView.findViewById(R.id.tvllvHora);
        TextView descricao = (TextView) rowView.findViewById(R.id.tvllvDescricao);

        hora.setText((int) rotinas.get(position).getHora().getTime());
        descricao.setText(rotinas.get(position).getDescricao());
        return rowView;
    }
}
