package no.teigmeland.familiehub.wicket.page.oppgaveliste;

import no.teigmeland.familiehub.domene.oppgaveliste.Oppgave;
import no.teigmeland.familiehub.tjeneste.oppgaveliste.OppgavelisteTjeneste;
import no.teigmeland.familiehub.wicket.WicketApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

public class ListTodoPage extends WebPage {

    public OppgavelisteTjeneste oppgavelisteTjeneste;

    public ListTodoPage(PageParameters parameters) {
        super(parameters);

        oppgavelisteTjeneste = WicketApplication.get().getOppgavelisteTjeneste();

            add(createTodoListView(oppgavelisteTjeneste.hentTodoListe()));
    }

    private ListView createTodoListView(final List<Oppgave> todoListe) {
        return new ListView("todoListView", todoListe) {
            @Override
            protected void populateItem(ListItem listItem) {
                Oppgave todoTekst = (Oppgave) listItem.getModelObject();

                listItem.add(new Label("todoListItem", todoTekst.getKortBeskrivelse()));
            }
        };
    }
}
