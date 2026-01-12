function loadScholarships() {
    api("/api/scholarships").then(list => {
        const el = document.getElementById("list");
        el.innerHTML = "";
        list.forEach(s => {
            el.innerHTML += `
        <div class="card">
          <b>${s.title}</b><br>
          amount: ${s.amount}<br>
          deadline: ${s.deadline}<br>
          slots: ${s.slots}<br>
          <span class="tag">${s.level}</span><br><br>
          <button onclick="apply(${s.id})">apply</button>
        </div>`;
        });
    });
}

function apply(id) {
    fetch("/api/apply", {
        method: "POST",
        headers: {"Content-Type":"application/x-www-form-urlencoded"},
        body: "user=1&scholarship=" + id
    }).then(() => alert("application submitted"));
}
