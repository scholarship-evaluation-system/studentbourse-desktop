api("/api/stats").then(d => {
    document.getElementById("stats").innerText =
        "awarded: " + d.awarded.join(", ");
});
