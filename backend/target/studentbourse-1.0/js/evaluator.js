function loadApplications() {
    api("/api/evaluator").then(list => {
        const el = document.getElementById("apps");
        el.innerHTML = "";
        list.forEach(a => {
            el.innerHTML += `
        <div class="card">
          ${a.student}<br>
          ${a.scholarship}<br>
          status: ${a.status}
        </div>`;
        });
    });
}
